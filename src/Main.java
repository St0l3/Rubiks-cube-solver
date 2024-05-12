public class Main {
    public static void main(String[] args) {
       // Cube c = Mover.scramble("R2 F2 R2 B' L2 B' U2 R2 U2 L2 U2 B2 D B' L2 R' D L' B2 L2 B");
        final Cube c = Mover.scramble("U2 L2 D2 R F2 L' F2 R' B2 U2 F R' U B2 D2 B' L2 U2 R2");
        // R2 F2 R2 B' L2 B' U2 R2 U2 L2 U2 B2 D B' L2 R' D L' B2 L2 B R F' B L' F F2 U' R' L2 B2 U D' R
        //System.out.println(CubeColorModel.getCubeModel(Mover.scramble("R2 F2 R2 B' L2 B' U2 R2 U2 L2 U2 B2 D B' L2 R' D L' B2 L2 B R F' B L' F")));
        //Cube cx = Mover.scramble("R2 F2 R2 B' L2 B' U2 R2 U2 L2 U2 B2 D B' L2 R' D L' B2 L2 B R F' B L' F");
//        System.out.println(cx);
//        for(Piece cr : cx.corners) System.out.println(cr);
        System.out.println();
        Solver.Solver(c);

    }
}