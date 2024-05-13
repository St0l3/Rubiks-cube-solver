public class Main {
    public static void main(String[] args) {
         Cube c = Mover.scramble("R2 F2 R2 B' L2 B' U2 R2 U2 L2 U2 B2 D B' L2 R' D L' B2 L2 B");
        // R2 F2 R2 B' L2 B' U2 R2 U2 L2 U2 B2 D B' L2 R' D L' B2 L2 B R F' B L' F F2 U' R' L2 B2 U D' R
        //System.out.println(CubeColorModel.getCubeModel(Mover.scramble("R2 F2 R2 B' L2 B' U2 R2 U2 L2 U2 B2 D B' L2 R' D L' B2 L2 B R F' B L' F")));
        //Cube cx = Mover.scramble("R2 F2 R2 B' L2 B' U2 R2 U2 L2 U2 B2 D B' L2 R' D L' B2 L2 B R F' B L' F");
//        System.out.println(cx);
//        for(Piece cr : cx.corners) System.out.println(cr);
       // System.out.println(Mover.scramble("R' U D' R D' R F' D2 B F2 U' F2 U F2 R2 L2 U' D' L2"));
      //  Cube c = new Cube().fPrime().b();
        Solver.Solver("R2 F2 R2 B' L2 B' U2 R2 U2 L2 U2 B2 D B' L2 R' D L' B2 L2 B");

    }
}