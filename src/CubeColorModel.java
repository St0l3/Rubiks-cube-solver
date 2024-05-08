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
            {w,r,g}, // URF  2
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

        String top = "     "+getCornerColor(corners[0],0) + " " + getEdgeColor(edges[0],0) + " " + getCornerColor(corners[1],0) + '\n' +
                "     "+   getEdgeColor(edges[3],0) + " " + "W " + getEdgeColor(edges[1],0) + '\n' +
                "     "+    getCornerColor(corners[3],0) + " " + getEdgeColor(edges[2],0) + " " +getCornerColor(corners[2],0);
                 ;
        return top;

    }
    public static char getEdgeColor(Piece e,int side)
    {
        return edgeColors[e.index][(side+e.orientation)%2];

    }

    private static char getCornerColor(Piece c, int side)
    {
        for (char ch:
             cornerColors[c.index]) {
            System.out.print(ch);
        }
        System.out.println();
        System.out.print(c);
        System.out.println();
        return cornerColors[c.index][(side+c.orientation)%3];

    }

}
