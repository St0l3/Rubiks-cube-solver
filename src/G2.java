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
        if((c.edges[Cube.UF].index != 0)&&(c.edges[Cube.UF].index != 2)&&(c.edges[Cube.UF].index != 8)&&(c.edges[Cube.UF].index != 10))
            return false;
        if((c.edges[Cube.UB].index != 0)&&(c.edges[Cube.UB].index != 2)&&(c.edges[Cube.UB].index != 8)&&(c.edges[Cube.UB].index != 10))
            return false;
        if((c.edges[Cube.DF].index != 0)&&(c.edges[Cube.DF].index != 2)&&(c.edges[Cube.DF].index != 8)&&(c.edges[Cube.DF].index != 10))
            return false;
        if((c.edges[Cube.DB].index != 0)&&(c.edges[Cube.DB].index != 2)&&(c.edges[Cube.DB].index != 8)&&(c.edges[Cube.DB].index != 10))
            return false;

        return true;
    }

    @Override
    public String getDescription() {
        return "grupa 2 | orijentisanje svih coskova i postavljanje ivica u M sloj | {F, F', B, B'} potezi nisu dozovoljeni";
    }
}
