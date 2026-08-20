# Rubik's Cube Solver

A Java command-line solver for the 3x3 Rubik's Cube, built on Thistlethwaite's algorithm. Give it a scramble in standard notation and it prints the move sequence that solves the cube, plus an ASCII picture of the cube after each stage.

No dependencies, no build tool. Two commands compile and run it.

## How it works

Thistlethwaite's method pushes the cube through four nested groups. Each stage takes away moves from the next one, so every search stays shallow enough for a plain depth-first walk.

| Stage | Goal | Moves allowed |
|-------|------|---------------|
| G1 | Orient all 12 edges | All 18 |
| G2 | Orient all 8 corners and park the four middle-layer edges in the middle layer | F and B limited to F2, B2 |
| G3 | Put each corner in its tetrad and each edge in its own slice | L, R, F, B limited to half turns |
| G4 | Solve the cube | Half turns only |

`Solver.IDDFS` runs iterative deepening on each stage: search to depth 1, then depth 2, and so on until `Group.isSatisfied` returns true. `Pruner` throws away a branch when the next move repeats the face of the previous move, or when it follows the opposite face out of order (L before R, B before F, D before U). That kills the duplicate orderings that would otherwise double the tree.

## Algorithms and data structures

| Technique | Where | Role |
|-----------|-------|------|
| Thistlethwaite's algorithm (1981), a four-group coset descent | [Solver.java](src/Solver.java), [G1.java](src/G1.java)–[G4.java](src/G4.java) | Splits one huge search into four small ones by shrinking the move set at each stage |
| Iterative deepening depth-first search | `Solver.IDDFS` | Finds the shortest sequence per stage while holding only the current path in memory |
| Move-ordering pruning | `Pruner.isPrunable` | Rejects a successor that repeats the previous face or turns opposite faces out of a fixed order, which removes permutations of commuting moves |
| Cubie-level state encoding | [Cube.java](src/Cube.java), [Piece.java](src/Piece.java) | Stores a permutation index and an orientation per cubie instead of 54 stickers, which shrinks the state and makes goal tests cheap |
| Modular orientation arithmetic | `Cube.updateCornerOrientation`, `CubeColorModel.getCornerColor` | Tracks corner twist mod 3 and edge flip mod 2, then maps index and orientation back to a sticker color |
| Persistent state, copy on move | `Cube(Cube)` copy constructor | Each of the 18 move methods returns a new cube, so backtracking costs nothing and no parent state gets corrupted |
| Strategy pattern over an abstract `Group` | [Group.java](src/Group.java) | Hands the search a legal move set and a goal test per stage, so one search routine drives all four |
| Stack-based backtracking | `Solver.IDDFS` | Pushes a move before recursing and pops it on failure, so the stack always holds the current candidate solution |
| Queue-based notation parser | `Mover.scramble`, `Mover.applyMoves` | Converts a scramble string into a move queue, then folds it over a fresh cube |

### Search cost

The move restrictions cut the branching factor at every stage: 18 successors in G1, 14 in G2, 10 in G3, and 6 in G4. Pruning drops a quarter to a third of those before recursion, averaged over the possible previous moves. A depth-first search at depth *d* holds *d* cubes, so memory stays flat while the node count climbs.

The search uses no pattern database or admissible distance estimate, which makes it IDDFS rather than IDA*. Adding a lookup table of goal distances per stage would be the next step toward Kociemba's two-phase method and its 20-move solutions.

## Cube model

`Cube` tracks 8 corner and 12 edge `Piece` objects, each holding an index and an orientation. Centers stay fixed on a 3x3, so the model leaves them out.

Every move method copies the cube and returns the copy, which keeps parent states intact during the search. `CubeColorModel` turns a cube into the unfolded net you see in the output.

## Running it

Requires a JDK 17 or newer for the arrow switches. The code builds and runs on JDK 21.

```bash
javac -d out src/*.java
```

```bash
java -cp out Main
```

`Main` ships with all of its solver calls commented out, so a fresh run prints nothing. Uncomment one of the ten sample scrambles in [src/Main.java](src/Main.java), or add your own:

```java
Solver.Solver("B D L2 U' L2 U2 L2 U F2 R2 U2 R2 U' L F R' B2 D2 R2");
```

Notation follows the standard: `R`, `R'`, `R2` for a clockwise, counter-clockwise, and double turn of the right face, and the same for `L`, `U`, `D`, `F`, `B`. Put one space between moves.

## Output

The program prints in Serbian. Sample tail of a run:

```
Pronadjeno resenje za G4: [ F2 B2 U2 R2 D2 R2 U2 F2 U2 F2 U2 ]
Resenje kocke je: F R2 L' U F L U F2 U' B2 R D L U L2 U L2 F2 U B2 U F2 B2 U2 R2 D2 R2 U2 F2 U2 F2 U2
```

| Serbian | English |
|---------|---------|
| Razmesana kocka | Scrambled cube |
| Zapoceto pretrazivanje | Search started |
| Zavrsena pretraga na dubini N | Finished the search at depth N |
| Pronadjeno resenje za G*n* | Found a solution for G*n* |
| Resenje kocke je | The cube solution is |

The ASCII net shows the U face on top, then L, F, R, B side by side, then D at the bottom. Letters mark colors: W, Y, B, G, R, O.

## Performance

Three of the bundled scrambles, timed on JDK 21 and a laptop CPU:

| Scramble | Time |
|----------|------|
| `B D L2 U' L2 U2 L2 U F2 R2 U2 R2 U' L F R' B2 D2 R2` | 3.9 s |
| `B' D2 F L2 B2 R2 D2 L2 D2 F2 U2 F2 L F D2 B' L2 U B D2 L'` | 3.9 s |
| `F2 R' D2 U2 F2 R D2 R U2 B2 L2 F2 B' U' R D B2 F D2 U2 L2` | 25.7 s |

Solutions land in the 30 to 40 move range. Thistlethwaite trades move count for search size, so you get an answer in seconds instead of the 20-move optimum that Kociemba's method hunts for.

## Files

| File | Role |
|------|------|
| [src/Cube.java](src/Cube.java) | Piece arrays and the 18 move methods |
| [src/Piece.java](src/Piece.java) | Index and orientation of one cubie |
| [src/Mover.java](src/Mover.java) | Parses notation strings, applies move sequences |
| [src/Solver.java](src/Solver.java) | Runs the four stages, iterative deepening search |
| [src/Pruner.java](src/Pruner.java) | Drops redundant move orderings |
| [src/Group.java](src/Group.java), [src/G1.java](src/G1.java)–[src/G4.java](src/G4.java) | Goal test and legal moves per stage |
| [src/CubeColorModel.java](src/CubeColorModel.java) | ASCII net rendering |
| [src/Main.java](src/Main.java) | Ten sample scrambles |

## Known limitations

`Mover.scramble` and `Mover.applyMoves` drop any token they fail to recognize. Type `R3` and the move vanishes with no error, which leaves you solving a different cube than you meant.

The entry point takes a scramble string, not a cube state, so you cannot type in the colors off a physical cube and solve from there.

Hard G3 stages dominate the runtime. The 25-second scramble above spends most of its time there.

## License

MIT. See [LICENSE](LICENSE).
