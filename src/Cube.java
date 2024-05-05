import java.util.Arrays;

public class Cube {
    // white yellow orange red blue green
    // Osnovna orijentacija kocke je zelena ispred bela gore
       public enum FACE{
           UP,LEFT,FRONT,RIGHT,BACK,DOWN
     }
     public enum COLOR{
           WHITE,GREEN,RED,BLUE,ORANGE,YELLOW
     }
     public enum EDGE{
           UB(0),UR(1),UF(2),UL(3),FR(4),FL(5),BR(6),BL(7),DF(8),DR(9),DB(10),DL(11);
         EDGE(int i){}
     }
     public final int ULB = 0;
    public final int URB = 1;
    public final int URF = 2;
    public final int ULF = 3;
    public final int DLF = 4;
    public final int DRF = 5;
    public final int DRB = 6;
    public final int DLB = 7;

     public enum CORNER
     {
         ULB(0),URB(1),URF(2),ULF(3),DLF(4),DRF(5),DRB(6),DLB(7);
         private final int c;
         CORNER(int i){
            this.c = i;
         }

     }
     public enum MOVE{
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
        this.corners = c.corners.clone();
        this.edges = c.edges.clone();
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
    {   ////////////////////////////////////
        Piece corner = corners[URF];
        corners[URF] = corners[DRF];
        corners[DRF] = corners[DRB];
        corners[DRB] = corners[URB];
        corners[URB] = corner;
        updateCornerOrientation(URF,2);
        updateCornerOrientation(URB,1);
        updateCornerOrientation(DRF,1);
        updateCornerOrientation(DRB,2);
        ////////////////////////////////////


        return this;
    }
    Cube rPrime()
    {
        Piece corner = corners[URF];
        corners[URF] = corners[URB];
        corners[URB] = corners[DRB];
        corners[DRB] = corners[DRF];
        corners[DRF] = corner;
        updateCornerOrientation(URF,2);
        updateCornerOrientation(URB,1);
        updateCornerOrientation(DRF,1);
        updateCornerOrientation(DRB,2);
        ////////////////////////////////////
        return this;

    }
    Cube r2()
    {
        /////////////////////////////////
        // Corners
        swap(corners[URF],corners[DRB]);
        swap(corners[URB],corners[DRF]);
        ///////////////////////////////////////
        return this;
    }

    private void swap(Piece a, Piece b)
    {
        Piece temp = a;
        a = b;
        b = temp;
    }
}
