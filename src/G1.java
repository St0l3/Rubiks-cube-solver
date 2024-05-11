public class G1 extends  Group{
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

        for (int i = 0; i<12;i++)
            if(c.edges[i].orientation==1)
                return false;
        return true;
    }

    @Override
    public String getDescription() {
        return "grupa 0 | orijentisanje svih ivica | svi potezi su dozvoljeni";
    }
}
