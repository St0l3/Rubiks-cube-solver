public class CubeColorModel
{
    static char w = 'W';
    static char y = 'Y';
    static char b = 'B';
    static char g = 'G';
    static char r = 'R';
    static char o = 'O';
    static Piece corners[];
    static Piece edges[];

    static char cornerColors[][] = {
            {w,o,b}, // ULB  0
            {w,r,b}, // URB  1
            {w,r,b}, // URF  2
            {w,o,g}, // ULF  3
            {y,o,g}, // DLF 4
            {y,r,g}, // DRF 5
            {y,r,b}, // DRB 6
            {y,o,b}, // DLB 7
    };
    static char edgeColors[][] = {
            {w,b}, // UB 0
            {w,r}, // UR 1
            {w,g}, // UF 2
            {w,o}, // UL 3

            {g,o}, // FL 4
            {b,o}, // BL 5
            {b,r}, // BR 6
            {g,r}, // FR 7

            {y,g}, // DF 8
            {y,o}, // DL 9
            {y,b}, // DB 10
            {y,r}  // DR 11
    };

    public static String getCubeModel(Cube c)
    {
        corners = c.corners;
        edges = c.edges;

        String top;
        return null;

    }

    private static int getCornerColor(Piece c, int side)
    {
        int orientation = c.orientation;
        if(orientation == 1){

        }

        return 0;
    }
    private static int getEdgeColor(Piece e,Boolean side)
    {
        int orientation = e.orientation;
        if(true){
            if(orientation == 1)
                return 0;
            return 1;
        }
        return orientation;
    }

}
