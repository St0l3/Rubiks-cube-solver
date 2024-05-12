public class G4 extends Group {
    @Override
    public Cube.MOVE[] getMoves() {
        Cube.MOVE moves[] = {Cube.MOVE.L2,
                Cube.MOVE.R2,
                Cube.MOVE.F2,
                Cube.MOVE.B2,
                Cube.MOVE.U2,
                Cube.MOVE.D2};
        return moves;
    }

    @Override
    public boolean isSatisfied(Cube c) {
       return c.isSolved();
    }

    @Override
    public String getDescription() {
        return "grupa 4 | Trazenje resenja samo uz poteze od 180 stepeni| {F, F', B, B', L, L', R, R', D, D', U, U'} potezi nisu dozovoljeni";
    }

    @Override
    public String getName() {
        return "G4";
    }
}
