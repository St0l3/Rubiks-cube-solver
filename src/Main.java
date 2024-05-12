import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Cube c = new Cube().r().r().u().rPrime().f().l2();
        System.out.println(CubeColorModel.getCubeModel(c));
        Group g = new TestGroup();
        Solver.IDDFS(c,g,new Stack<>());
    }
}