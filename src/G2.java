public class G2 extends Group{
    @Override
    public Cube.MOVE[] getMoves() {
        Cube.MOVE moves[] = { Cube.MOVE.L, Cube.MOVE.LP, Cube.MOVE.L2,
                Cube.MOVE.R, Cube.MOVE.RP, Cube.MOVE.R2,
                Cube.MOVE.F2,
                Cube.MOVE.B2,
                Cube.MOVE.U, Cube.MOVE.UP, Cube.MOVE.U2,
                Cube.MOVE.D, Cube.MOVE.DP, Cube.MOVE.D2};
        return moves;
    }

    @Override
    public boolean isSatisfied(Cube c) {
        for (int i = 0; i<8;i++)
            if(c.corners[i].orientation!=0)
                return false;
        if((c.edges[Cube.FR].index != 7)&&(c.edges[Cube.FR].index != 4)&&(c.edges[Cube.FR].index != 5)&&(c.edges[Cube.FR].index != 6))
            return false;
        if((c.edges[Cube.FL].index != 4)&&(c.edges[Cube.FL].index != 5)&&(c.edges[Cube.FL].index != 6)&&(c.edges[Cube.FL].index != 7))
            return false;
        if((c.edges[Cube.BL].index != 4)&&(c.edges[Cube.BL].index != 5)&&(c.edges[Cube.BL].index != 6)&&(c.edges[Cube.BL].index != 7))
            return false;
        if((c.edges[Cube.BR].index != 7)&&(c.edges[Cube.BR].index != 4)&&(c.edges[Cube.BR].index != 5)&&(c.edges[Cube.BR].index != 6))
            return false;
        return true;
    }

    @Override
    public String getDescription() {
        return "grupa 2 | orijentisanje svih coskova i postavljanje ivica u S sloj | {F, F', B, B'} potezi nisu dozovoljeni";
    }

    @Override
    public String getName() {
        return "G2";
    }
}
