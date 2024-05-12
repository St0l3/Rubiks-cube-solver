import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solver {

    public static void Solver(Cube c){

        Group group = new G1();



    }
    public static void IDDFS(Cube cube, Group group, Stack<Cube.MOVE> moves){
        int maxDepth = 0;
        while(!IDDFS(cube,0,maxDepth,group,moves))
        {
            System.out.println("Pretrazivanje na dubini: " +maxDepth+1);
            maxDepth++;
        }
        System.out.println("Pronadjeno resenje za " +group.getName());
        System.out.println(Scramble.moveToString(moves));

    }



    private static boolean IDDFS(Cube cube, int depth, int maxDepth, Group group, Stack<Cube.MOVE> moves)
    {
        System.out.println("     Dubina" + depth);
        Cube.MOVE[] permittedMoves = group.getMoves();
        if(depth == maxDepth) {
            return group.isSatisfied(cube);
        }
        for(Cube.MOVE move : permittedMoves){
            if(!moves.isEmpty()&&Pruner.isPrunable(moves.peek(),move))
                continue;
            moves.push(move);
                if(IDDFS(cube.move(move),depth+1,maxDepth,group,moves))
                    return true;
                else
                    moves.pop();
        }


        return false;
    }



}
