public class G3 extends Group{
    @Override
    public Cube.MOVE[] getMoves() {
        Cube.MOVE moves[] = {Cube.MOVE.L2,
                Cube.MOVE.R2,
                Cube.MOVE.F2,
                Cube.MOVE.B2,
                Cube.MOVE.U, Cube.MOVE.UP, Cube.MOVE.U2,
                Cube.MOVE.D, Cube.MOVE.DP, Cube.MOVE.D2};
        return moves;
    }

    @Override
    public boolean isSatisfied(Cube c) {
        for (int i = 0; i<8;i++)
            if((c.corners[i].index+i)%2!=0)
                return false;
        // S slice
        if((c.edges[Cube.UR].index != 1)&&(c.edges[Cube.UR].index != 3)&&(c.edges[Cube.UR].index != 9)&&(c.edges[Cube.UR].index != 11))
            return false;
        if((c.edges[Cube.UL].index != 1)&&(c.edges[Cube.UL].index != 3)&&(c.edges[Cube.UL].index != 9)&&(c.edges[Cube.UL].index != 11))
            return false;
        if((c.edges[Cube.DL].index != 1)&&(c.edges[Cube.DL].index != 3)&&(c.edges[Cube.DL].index != 9)&&(c.edges[Cube.DL].index != 11))
            return false;
        if((c.edges[Cube.DR].index != 1)&&(c.edges[Cube.DR].index != 3)&&(c.edges[Cube.DR].index != 9)&&(c.edges[Cube.DR].index != 11))
            return false;
        // E slice
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
        return "grupa 3 | permutovanje coskova u svoju parnost, permutovanje ivica u svoju liniju | {F, F', B, B', L, L', R, R'} potezi nisu dozovoljeni";
    }

    @Override
    public String getName() {
        return "G3";
    }
}
