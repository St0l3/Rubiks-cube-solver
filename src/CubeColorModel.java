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

        String top = "\n       " + getCornerColor(0,0) + " " + getEdgeColor(edges[0],0) + " " + getCornerColor(1,0) + '\n' +
                     "       " + getEdgeColor(edges[3],0)  +      " W "                          +       getEdgeColor(edges[1],0) + '\n' +
                     "       " + getCornerColor(3,0) + " " + getEdgeColor(edges[2],0) + " " + getCornerColor(2,0);


        String middle =   getCornerColor(0,1) + " " + getEdgeColor(edges[3],1) + " "+ getCornerColor(3,1) + "  " + // Prvi red L strane
                          getCornerColor(3,2) + " " + getEdgeColor(edges[2],1) + " "+ getCornerColor(2,2) + "  " + // Prvi red F strane
                          getCornerColor(2,1) + " " + getEdgeColor(edges[1],1)+ " "+ getCornerColor(1,1) + "  " + // Prvi red R strane
                          getCornerColor(1,2) + " " + getEdgeColor(edges[0],1) + " "+ getCornerColor(0,2) + "  " + // Prvi red B strane
                            "\n" +
                            getEdgeColor(edges[5],1) + " O " + getEdgeColor(edges[4],1) + "  " +// Drugi red L strane
                            getEdgeColor(edges[4],0) + " G " + getEdgeColor(edges[7],0) + "  " + // Drugi red F strane
                            getEdgeColor(edges[7],1) + " R " + getEdgeColor(edges[6],1) + "  " + // Drugi red R strane
                            getEdgeColor(edges[6],0) + " B " + getEdgeColor(edges[5],0) + "  " + // Drugi red B strane
                            "\n" +
                          getCornerColor(7,1) + " " + getEdgeColor(edges[9],1) + " "+getCornerColor(4,1) + "  " + // Treci red L strane
                          getCornerColor(4,2) + " " + getEdgeColor(edges[8],1) + " "+ getCornerColor(5,2) + "  " + // Treci red F strane
                          getCornerColor(5,1) + " " + getEdgeColor(edges[11],1) + " "+ getCornerColor(6,1) + "  " + // Treci red R strane
                          getCornerColor(6,2) + " " + getEdgeColor(edges[10],1) + " "+ getCornerColor(7,2) + "  ";  // Treci red B strane



                String bot = "       " + getCornerColor(4,0) + " " + getEdgeColor(edges[8],0) + " " + getCornerColor(5,0) + '\n' +
                     "       " + getEdgeColor(edges[9],0)  +      " Y "                          +       getEdgeColor(edges[11],0) + '\n' +
                     "       " + getCornerColor(7,0) + " " + getEdgeColor(edges[10],0) + " " + getCornerColor(6,0);

        return top + "\n\n" +middle+ "\n\n" + bot;

    }
    public static char getEdgeColor(Piece e,int side)
    {
        return edgeColors[e.index][(side+e.orientation)%2];

    }

    private static char getCornerColor(int index, int side) {
        Piece c = corners[index];
        return cornerColors[c.index][(((side+2*c.orientation*(1+c.index%2))%3)+side*((c.index+index)%2))%3];

    }

}
