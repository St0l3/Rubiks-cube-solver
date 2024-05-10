import java.util.LinkedList;
import java.util.Queue;

public class Scramble
{
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
