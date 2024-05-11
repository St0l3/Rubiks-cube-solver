public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube().u().d();
        Group g = new G2();
        System.out.println(g.getDescription());
        //cube = Scramble.scramble("D R2 F L F' L' F' U2 F2 U' B2 U R2 F2 U' F2 D L2 F");
        System.out.println(g.isSatisfied(cube.dPrime().uPrime()));
    }
}