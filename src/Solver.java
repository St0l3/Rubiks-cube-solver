import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Solver {

    private static int n =0;
    public static void Solver(String s){

        System.out.println("Scramble: " + s);
        Cube c = Mover.scramble(s);
        System.out.println(c);
        System.out.println();
        //G1
        Group group = new G1();
        Stack<Cube.MOVE> G1moves = new Stack<>();
        IDDFS(c,group,G1moves);
        System.out.println("Finished IDDFS G1");
        c = Mover.applyMoves(c, Objects.requireNonNull(Mover.moveToString(G1moves)));
        System.out.println("G1 cube: " + c);
        //G2
        group = new G2();
        Stack<Cube.MOVE> G2moves = new Stack<>();
        IDDFS(c,group,G2moves);
        System.out.println("Finished IDDFS G2");
        c = Mover.applyMoves(c, Objects.requireNonNull(Mover.moveToString(G2moves)));
        System.out.println("G2 cube: " + c);
        //G3
        group = new G3();
        Stack<Cube.MOVE> G3moves = new Stack<>();
        IDDFS(c,group,G3moves);
        System.out.println("Finished IDDFS G3");
        c = Mover.applyMoves(c, Objects.requireNonNull(Mover.moveToString(G3moves)));

        //G4

//        System.out.println(c);
//        c.getCorner();


    }
    public static void IDDFS(final Cube cube, Group group, Stack<Cube.MOVE> moves){
        int maxDepth = 0;
        System.out.println("Zapoceto pretrazivanje: " + group.getDescription());
        System.out.println();
        while(!IDDFS(cube,0,maxDepth,group,moves))
        {
            System.out.println("    Pretrazivanje na dubini: " +(maxDepth+1) +", indeks poslednje pretrage: " + n);
            maxDepth++;
        }
        System.out.println("Pronadjeno resenje za " +group.getName() + ": [ " + Mover.moveToString(moves)+"]");
        System.out.println();

    }



    private static boolean IDDFS(final Cube cube, int depth, int maxDepth, Group group, Stack<Cube.MOVE> moves)
    {
          n++;
//        System.out.println();
//        System.out.println("Depth | Max Depth | Node = " + depth +", "+ maxDepth + ", "+n);
      //  System.out.println(cube);
//        cube.getCorner();
        Cube.MOVE[] permittedMoves = group.getMoves();
        if(depth == maxDepth) {
            return group.isSatisfied(cube);
        }
        for(Cube.MOVE move : permittedMoves){
            if(!moves.isEmpty()&&Pruner.isPrunable(moves.peek(),move))
                continue;
            moves.add(move);
            if(IDDFS(cube.move(move),depth+1,maxDepth,group,moves))
            {
                return true;
            }
            moves.pop();

        }
        return false;
    }



}
