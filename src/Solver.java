import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Solver {
    
    public static void Solver(String s){

        System.out.println("Razmesana kocka: " + s);
        Cube c = Mover.scramble(s);
        System.out.println(c);
        System.out.println();
        //G1
        Group group = new G1();
        Stack<Cube.MOVE> G1moves = new Stack<>();
        IDDFS(c,group,G1moves);
        c = Mover.applyMoves(c, Objects.requireNonNull(Mover.moveToString(G1moves)));
        System.out.println("G1 kocka: " + c);

        //G2
        group = new G2();
        Stack<Cube.MOVE> G2moves = new Stack<>();
        IDDFS(c,group,G2moves);
        c = Mover.applyMoves(c, Objects.requireNonNull(Mover.moveToString(G2moves)));
        System.out.println("G2 kocka: " + c);

        //G3
        group = new G3();
        Stack<Cube.MOVE> G3moves = new Stack<>();
        IDDFS(c,group,G3moves);
        c = Mover.applyMoves(c, Objects.requireNonNull(Mover.moveToString(G3moves)));
        System.out.println(c);
        //G4
        group = new G4();
        Stack<Cube.MOVE> G4moves = new Stack<>();
        IDDFS(c,group,G4moves);
        c = Mover.applyMoves(c, Objects.requireNonNull(Mover.moveToString(G4moves)));
        String solution =  Mover.moveToString(G1moves)+Mover.moveToString(G2moves)+Mover.moveToString(G3moves)+Mover.moveToString(G4moves);
        System.out.println("Resenje kocke je: " + solution);



    }
    public static void IDDFS(final Cube cube, Group group, Stack<Cube.MOVE> moves){
        int maxDepth = 0;
        System.out.println("Zapoceto pretrazivanje: " + group.getDescription());
        System.out.println();
        while(!IDDFS(cube,0,maxDepth,group,moves))
        {
            System.out.println("    Zavrsena pretraga na dubini " +(maxDepth+1) );
            maxDepth++;
        }
        System.out.println("Pronadjeno resenje za " +group.getName() + ": [ " + Mover.moveToString(moves)+"]");

    }



    private static boolean IDDFS(final Cube cube, int depth, int maxDepth, Group group, Stack<Cube.MOVE> moves)
    {
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
