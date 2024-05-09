import java.util.Arrays;

public class Cube {
    // white yellow orange red blue green
    // Osnovna orijentacija kocke je zelena ispred bela gore

     public static final int ULB = 0;
    public static final int URB = 1;
    public static final int URF = 2;
    public static final int ULF = 3;
    public static final int DLF = 4;
    public static final int DRF = 5;
    public static final int DRB = 6;
    public static final int DLB = 7;

    public static final int UB = 0;
    public static final int UR = 1;
    public static final int UF = 2;
    public static final int UL = 3;
    public static final int FL = 4;
    public static final int BL = 5;
    public static final int BR = 6;
    public static final int FR = 7;
    public static final int DF = 8;
    public static final int DL = 9;
    public static final int DB = 10;
    public static final int DR=11;
     public static enum MOVE{
           L,LP,L2,
         R,RP,R2,
         F,FP,F2,
         B,BP,B2,
         U,UP,U2,
         D,DP,D2

     }

     public Piece corners[];
       public Piece edges[];
    public Cube() {
        //initialize corners to solved state
        corners = new Piece[8];
        for(int i = 0; i < 8;i++){
          //  System.out.println(i);
            corners[i] = new Piece( i, 0);
        }
        edges = new Piece[12];
        for(int i = 0; i < 12;i++){
            edges[i] = new Piece(i,0);
        }

    }
    public Cube(Cube c)
    {
        corners = new Piece[8];
        edges = new Piece[12];
        for(int i = 0; i < 8;i++){
            //  System.out.println(i);
            corners[i] = new Piece( c.corners[i]);
        }
        for(int i = 0; i < 12;i++){
            edges[i] = new Piece(c.edges[i]);
        }
    }




    public void updateEdgeOrientation(int index, int amount)
    {
        Piece edge = edges[index];
        edge.orientation +=amount;
        if(edge.orientation==2)
            edge.orientation = 0;
    }
    public void updateCornerOrientation(int index, int amount){
        Piece corner = corners[index];
         corner.orientation += amount;
         if(corner.orientation==3)
             corner.orientation = 0;
         if(corner.orientation==4)
             corner.orientation = 1;
    }

    Cube r()
    {
        Cube c = new Cube(this);
        ////////////////////////////////////
        Piece corner = c.corners[URF];
        c.corners[URF] = c.corners[DRF];
        c.corners[DRF] = c.corners[DRB];
        c.corners[DRB] = c.corners[URB];
        c.corners[URB] = corner;
        c.updateCornerOrientation(URF,2);
        c.updateCornerOrientation(URB,1);
        c.updateCornerOrientation(DRF,1);
        c.updateCornerOrientation(DRB,2);
        ////////////////////////////////////
        Piece edge = edges[FR];
        c.edges[FR]= c.edges[DR];
        c.edges[DR] = c.edges[BR];
        c.edges[BR] = c.edges[UR];
        c.edges[UR] = edge;
        return c;
    }
    Cube rPrime()
    {
        Cube c = new Cube(this);
        //////////////////////////////
        Piece corner = corners[URF];
        c.corners[URF] = c.corners[URB];
        c.corners[URB] = c.corners[DRB];
        c.corners[DRB] = c.corners[DRF];
        c.corners[DRF] = corner;
        c.updateCornerOrientation(URF,2);
        c.updateCornerOrientation(URB,1);
        c.updateCornerOrientation(DRF,1);
        c.updateCornerOrientation(DRB,2);
        ////////////////////////////////////
        Piece edge = edges[FR];
        c.edges[FR] = c.edges[UR];
        c.edges[UR] = c.edges[BR];
        c.edges[BR] = c.edges[DR];
        c.edges[DR] = edge;


        return c;

    }
    Cube r2()
    {
        Cube c = new Cube(this);
        /////////////////////////////////
        // Corners

        c.swapC(URF,DRB);
        c.swapC(URB,DRF);
        ///////////////////////////////////////
        c.swapE(UR,DR);
        c.swapE(FR,BR);
        return c;
    }
    Cube l()
    {
        Cube c = new Cube(this);
        // Corners;
        Piece corner = c.corners[ULB];
        c.corners[ULB] = c.corners[DLB];
        c.corners[DLB] = c.corners[DLF];
        c.corners[DLF] = c.corners [ULF];
        c.corners[ULF] = corner;
       // c.updateCornerOrientation();
        return c;
    }
    private void swapE(int a, int b)
    {
        Piece temp = edges[a];
        edges[a] = edges[b];
        edges[b] = temp;
    }
    private void swapC(int a, int b)
    {
        Piece temp = corners[a];
        corners[a] = corners[b];
        corners[b] = temp;
    }

    @Override
    public String toString() {
        return CubeColorModel.getCubeModel(this);
    }
}
