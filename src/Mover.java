import java.util.*;

public class Mover
{

    public static Cube applyMoves(Cube cube, String s ){
        Cube c = new Cube(cube);
        Queue<Cube.MOVE> moveOrder = new LinkedList<>();
        String[] moves = s.trim().split(" ");
        for (String move:moves) {
            switch (move) {
                case "R" -> moveOrder.add(Cube.MOVE.R);
                case "R2" -> moveOrder.add(Cube.MOVE.R2);
                case "R'" -> moveOrder.add(Cube.MOVE.RP);
                case "L" -> moveOrder.add(Cube.MOVE.L);
                case "L2" -> moveOrder.add(Cube.MOVE.L2);
                case "L'" -> moveOrder.add(Cube.MOVE.LP);
                case "F" -> moveOrder.add(Cube.MOVE.F);
                case "F'" -> moveOrder.add(Cube.MOVE.FP);
                case "F2" -> moveOrder.add(Cube.MOVE.F2);
                case "B" -> moveOrder.add(Cube.MOVE.B);
                case "B'" -> moveOrder.add(Cube.MOVE.BP);
                case "B2" -> moveOrder.add(Cube.MOVE.B2);
                case "U" -> moveOrder.add(Cube.MOVE.U);
                case "U'" -> moveOrder.add(Cube.MOVE.UP);
                case "U2" -> moveOrder.add(Cube.MOVE.U2);
                case "D" -> moveOrder.add(Cube.MOVE.D);
                case "D'" -> moveOrder.add(Cube.MOVE.DP);
                case "D2" -> moveOrder.add(Cube.MOVE.D2);
                default -> {
                }
            }
        }
        for(Cube.MOVE m : moveOrder) {
            System.out.print(m+" ");
            c = c.move(m);
        }
        System.out.println();
        return c;
    }
    public static String moveToString(Stack<Cube.MOVE> moves){
        StringBuilder m = new StringBuilder();
        for (Cube.MOVE move : moves) {
            switch (move) {
                case L -> {
                    m.append("L ");
                }
                case LP -> {
                    m.append("L' ");
                }
                case L2 -> {
                    m.append("L2 ");
                }
                case R -> {
                    m.append("R ");
                }
                case RP -> {
                    m.append("R' ");
                }
                case R2 -> {
                    m.append("R2 ");
                }
                case F -> {
                    m.append("F ");
                }
                case FP -> {
                    m.append("F' ");
                }
                case F2 -> {
                    m.append("F2 ");
                }
                case B -> {
                    m.append("B ");
                }
                case BP -> {
                    m.append("B' ");
                }
                case B2 -> {
                    m.append("B2 ");
                }
                case U -> {
                    m.append("U ");
                }
                case UP -> {
                    m.append("U' ");
                }
                case U2 -> {
                    m.append("U2 ");
                }
                case D -> {
                    m.append("D ");
                }
                case DP -> {
                    m.append("D' ");
                }
                case D2 -> {
                    m.append("D2");
                }
                default -> {
                    return null;
                }
            }
        }
        return m.toString();
    }
    public static Cube scramble(String scr)
    {
        Cube cube = new Cube();
        Queue<Cube.MOVE> moveOrder = new LinkedList<>();
        String[] moves = scr.split(" ");
        if(moves.length==0)
            return cube;
        for (String move:moves) {
            switch(move)
            {
                case "R":
                    moveOrder.add(Cube.MOVE.R);
                    break;
                case "R2":
                    moveOrder.add(Cube.MOVE.R2);
                    break;
                case "R'":
                    moveOrder.add(Cube.MOVE.RP);
                    break;
                case "L":
                    moveOrder.add(Cube.MOVE.L);
                    break;
                case "L2":
                    moveOrder.add(Cube.MOVE.L2);
                    break;
                case "L'":
                    moveOrder.add(Cube.MOVE.LP);
                    break;
                case "F":
                    moveOrder.add(Cube.MOVE.F);
                    break;
                case "F'":
                    moveOrder.add(Cube.MOVE.FP);
                    break;
                case "F2":
                    moveOrder.add(Cube.MOVE.F2);
                    break;
                case "B":
                    moveOrder.add(Cube.MOVE.B);
                    break;
                case "B'":
                    moveOrder.add(Cube.MOVE.BP);
                    break;
                case "B2":
                    moveOrder.add(Cube.MOVE.B2);
                    break;
                case "U":
                    moveOrder.add(Cube.MOVE.U);
                    break;
                case "U'":
                    moveOrder.add(Cube.MOVE.UP);
                    break;
                case "U2":
                    moveOrder.add(Cube.MOVE.U2);
                    break;
                case "D":
                    moveOrder.add(Cube.MOVE.D);
                    break;
                case "D'":
                    moveOrder.add(Cube.MOVE.DP);
                    break;
                case "D2":
                    moveOrder.add(Cube.MOVE.D2);
                    break;
                default:
                    break;
            }
        }
        for(Cube.MOVE m : moveOrder) {
            cube = cube.move(m);
        }
        return cube;
    }
}
