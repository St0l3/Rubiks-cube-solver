public class TestGroup extends Group{
    @Override
    public Cube.MOVE[] getMoves() {
        Cube.MOVE moves[] = { Cube.MOVE.L, Cube.MOVE.LP, Cube.MOVE.L2,
                Cube.MOVE.R, Cube.MOVE.RP, Cube.MOVE.R2,
                Cube.MOVE.F, Cube.MOVE.FP, Cube.MOVE.F2,
                Cube.MOVE.B, Cube.MOVE.BP, Cube.MOVE.B2,
                Cube.MOVE.U, Cube.MOVE.UP, Cube.MOVE.U2,
                Cube.MOVE.D, Cube.MOVE.DP, Cube.MOVE.D2};
        return moves;
    }

    @Override
    public boolean isSatisfied(Cube c) {
        return c.isSolved();
    }

    @Override
    public String getDescription() {
        return "Test";
    }

    @Override
    public String getName() {
        return "Test";
    }
}
