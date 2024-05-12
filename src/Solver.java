import java.util.*;

public class Solver {

    private static int n =0;
    public static void Solver(final Cube c){

        System.out.println(c);
        c.getCorner();
        Cube cpy = new Cube(c);
        System.out.println();
        Group group = new G1();
        Stack<Cube.MOVE> G1moves = new Stack<>();
        IDDFS(c,group,G1moves);
        System.out.println("Finished IDDFS g1");
        c.getCorner();
//        c = Mover.applyMoves(c, Objects.requireNonNull(Mover.moveToString(G1moves)));
//        cpy = new Cube(c);
//        group = new G2();
//        Stack<Cube.MOVE> G2moves = new Stack<>();
//        IDDFS(cpy,group,G2moves);
//        c = Mover.applyMoves(c, Objects.requireNonNull(Mover.moveToString(G2moves)));
//        System.out.println(c);
//        for(Piece corners : c.corners) System.out.println(corners);


    }
    public static void IDDFS(final Cube cube, Group group, Stack<Cube.MOVE> moves){
        int maxDepth = 0;
        System.out.println("Zapoceto pretrazivanje: " + group.getDescription());
        while(!IDDFS(cube,0,maxDepth,group,moves))
        {
            System.out.println("    Pretrazivanje na dubini: " +(maxDepth+1) +", broj grane: " + n);
            maxDepth++;
        }
        System.out.println("Pronadjeno resenje za " +group.getName() + ": [ " + Mover.moveToString(moves)+"]");
        System.out.println();

    }



    private static boolean IDDFS(final Cube cube, int depth, int maxDepth, Group group, Stack<Cube.MOVE> moves)
    {
        n++;
        Cube.MOVE[] permittedMoves = group.getMoves();
        if(depth == maxDepth) {
            return group.isSatisfied(cube);
        }
        for(Cube.MOVE move : permittedMoves){
            if(!moves.isEmpty()&&Pruner.isPrunable(moves.peek(),move))
                continue;
            moves.add(move);
            if(IDDFS(cube.move(move),depth+1,maxDepth,group,moves))
                    return true;
            moves.pop();

        }


        return false;
    }



}
