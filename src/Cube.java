import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Cube {
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
    public Cube(final Cube c)
    {
       corners = new Piece[8];
       edges = new Piece[12];
        for(int i = 0; i < 8;i++){
            //  System.out.println(i);
            corners[i] = new Piece(c.corners[i]);
        }
        for(int i = 0; i < 12;i++){
            edges[i] = new Piece(c.edges[i]);
        }
    }
    public Boolean isSolved()
    {
        for(int i = 0; i < 8;i++){
            if(corners[i].index !=i)
                return false;
        }
        for(int i = 0; i < 12;i++){
            if(edges[i].index != i)
                return false;
        }
        return true;
    }
    public Cube move(MOVE move)
    {
        switch (move){
            case L -> {
                return this.l();
            }
            case LP -> {
                return this.lPrime();
            }
            case L2 -> {
                return this.l2();
            }
            case R -> {
                return this.r();}

            case RP -> {
                return this.rPrime();
            }
            case R2 -> {
                return this.r2();
            }
            case F -> {
                return this.f();
            }
            case FP -> {
                return this.fPrime();
            }
            case F2 -> {
                return this.f2();
            }
            case B -> {
                return  this.b();
            }
            case BP -> {
                return  this.bPrime();
            }
            case B2 -> {
                return  this.b2();
            }
            case U -> {
                return this.u();
            }
            case UP -> {
                return this.uPrime();
            }
            case U2 -> {
                return  this.u2();
            }
            case D -> {
                return this.d();
            }
            case DP -> {
                return this.dPrime();
            }
            case D2 -> {
                return this.d2();
            }
            default -> {
                return null;
            }
        }
    }

    private void updateEdgeOrientation(int index)
    {
        Piece edge = edges[index];
        edge.orientation +=1;
        if(edge.orientation==2)
            edge.orientation = 0;
    }
    private void updateCornerOrientation(int index, int amount){
        Piece corner = corners[index];
         corner.orientation += amount;
         if(corner.orientation==3)
             corner.orientation = 0;
         if(corner.orientation==4)
             corner.orientation = 1;
    }
    Cube b2()
    {
        Cube c = new Cube(this);
        // Corners
        c.swapC(ULB,DRB);
        c.swapC(URB,DLB);
        // Edges
        c.swapE(UB,DB);
        c.swapE(BR,BL);
        return c;

    }
    Cube bPrime(){
        Cube c = new Cube(this);
        // Corners
        Piece corner = c.corners[ULB];
        c.corners[ULB] = c.corners[DLB];
        c.corners[DLB] = c.corners[DRB];
        c.corners[DRB] = c.corners[URB];
        c.corners[URB] = corner;
        c.updateCornerOrientation(ULB,1);
        c.updateCornerOrientation(DLB,2);
        c.updateCornerOrientation(DRB,1);
        c.updateCornerOrientation(URB,2);
        // Edges
        Piece edge = c.edges[UB];
        c.edges[UB] = c.edges[BL];
        c.edges[BL] = c.edges[DB];
        c.edges[DB] = c.edges[BR];
        c.edges[BR] = edge;
        c.updateEdgeOrientation(UB);
        c.updateEdgeOrientation(BL);
        c.updateEdgeOrientation(DB);
        c.updateEdgeOrientation(BR);

        return c;
    }

    Cube b(){
        Cube c = new Cube(this);
        // Corners
        Piece corner = c.corners[ULB];
        c.corners[ULB] = c.corners[URB];
        c.corners[URB] = c.corners[DRB];
        c.corners[DRB] = c.corners[DLB];
        c.corners[DLB] = corner;
        c.updateCornerOrientation(ULB,1);
        c.updateCornerOrientation(DLB,2);
        c.updateCornerOrientation(DRB,1);
        c.updateCornerOrientation(URB,2);
        // Edges
        Piece edge = c.edges[UB];
        c.edges[UB] = c.edges[BR];
        c.edges[BR] = c.edges[DB];
        c.edges[DB] = c.edges[BL];
        c.edges[BL] = edge;
        c.updateEdgeOrientation(UB);
        c.updateEdgeOrientation(BL);
        c.updateEdgeOrientation(DB);
        c.updateEdgeOrientation(BR);

        return c;
    }
    Cube fPrime(){
        Cube c = new Cube(this);
        // Corners
        Piece corner = c.corners[ULF];
        c.corners[ULF] = c.corners[URF];
        c.corners[URF] = c.corners[DRF];
        c.corners[DRF] = c.corners[DLF];
        c.corners[DLF] = corner;
        c.updateCornerOrientation(ULF,2);
        c.updateCornerOrientation(DLF,1);
        c.updateCornerOrientation(DRF,2);
        c.updateCornerOrientation(URF,1);
        // Edges
        Piece edge = c.edges[UF];
        c.edges[UF] = c.edges[FR];
        c.edges[FR] = c.edges[DF];
        c.edges[DF] = c.edges[FL];
        c.edges[FL] = edge;
        c.updateEdgeOrientation(UF);
        c.updateEdgeOrientation(FL);
        c.updateEdgeOrientation(DF);
        c.updateEdgeOrientation(FR);

        return c;
    }
    Cube f2(){
        Cube c = new Cube(this);
        // Corners
        c.swapC(ULF,DRF);
        c.swapC(URF,DLF);
        // Edges
        c.swapE(UF,DF);
        c.swapE(FR,FL);
        return c;
    }

    Cube f(){
        Cube c = new Cube(this);
        // Corners
        Piece corner = c.corners[ULF];
        c.corners[ULF] = c.corners[DLF];
        c.corners[DLF] = c.corners[DRF];
        c.corners[DRF] = c.corners[URF];
        c.corners[URF] = corner;
        c.updateCornerOrientation(ULF,2);
        c.updateCornerOrientation(DLF,1);
        c.updateCornerOrientation(DRF,2);
        c.updateCornerOrientation(URF,1);
        // Edges
        Piece edge = c.edges[UF];
        c.edges[UF] = c.edges[FL];
        c.edges[FL] = c.edges[DF];
        c.edges[DF] = c.edges[FR];
        c.edges[FR] = edge;
        c.updateEdgeOrientation(UF);
        c.updateEdgeOrientation(FL);
        c.updateEdgeOrientation(DF);
        c.updateEdgeOrientation(FR);

        return c;
    }

    Cube dPrime(){
        Cube c = new Cube(this);
        // Corners
        Piece corner = c.corners[DLB];
        c.corners[DLB] = c.corners[DLF];
        c.corners[DLF] = c.corners[DRF];
        c.corners[DRF] = c.corners[DRB];
        c.corners[DRB] = corner;
        // Edges
        Piece edge = c.edges[DB];
        c.edges[DB] = c.edges[DL];
        c.edges[DL] = c.edges[DF];
        c.edges[DF] = c.edges[DR];
        c.edges[DR] = edge;

        return c;
    }

    Cube d2(){
        Cube c = new Cube(this);
        // Corners
        c.swapC(DRF,DLB);
        c.swapC(DRB,DLF);
        // Edges
        c.swapE(DR,DL);
        c.swapE(DB,DF);
        return c;

    }
    Cube d(){
        Cube c = new Cube(this);
        // Corners
        Piece corner = c.corners[DLB];
        c.corners[DLB] = c.corners[DRB];
        c.corners[DRB] = c.corners[DRF];
        c.corners[DRF] = c.corners[DLF];
        c.corners[DLF] = corner;
        // Edges
        Piece edge = c.edges[DB];
        c.edges[DB] = c.edges[DR];
        c.edges[DR] = c.edges[DF];
        c.edges[DF] = c.edges[DL];
        c.edges[DL] = edge;

        return c;
    }
    Cube u2(){
        Cube c = new Cube(this);
        // Corners
        c.swapC(URF,ULB);
        c.swapC(URB,ULF);
        // Edges
        c.swapE(UR,UL);
        c.swapE(UB,UF);
        return c;

    }
    Cube uPrime()
    {
        Cube c = new Cube(this);
        // Corners
        Piece corner = c.corners[ULB];
        c.corners[ULB] = c.corners[URB];
        c.corners[URB] = c.corners[URF];
        c.corners[URF] = c.corners[ULF];
        c.corners[ULF] = corner;
        // Edges
        Piece edge = c.edges[UB];
        c.edges[UB] = c.edges[UR];
        c.edges[UR] = c.edges[UF];
        c.edges[UF] = c.edges[UL];
        c.edges[UL] = edge;

        return c;
    }
    Cube u(){
        Cube c = new Cube(this);
        // Corners
        Piece corner = c.corners[ULB];
        c.corners[ULB] = c.corners[ULF];
        c.corners[ULF] = c.corners[URF];
        c.corners[URF] = c.corners[URB];
        c.corners[URB] = corner;
        // Edges
        Piece edge = c.edges[UB];
        c.edges[UB] = c.edges[UL];
        c.edges[UL] = c.edges[UF];
        c.edges[UF] = c.edges[UR];
        c.edges[UR] = edge;

        return c;
    }


    Cube r()
    {
        Cube c = new Cube(this);
        // Corners
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
        Piece edge = c.edges[FR];
        c.edges[FR]= c.edges[DR];
        c.edges[DR] = c.edges[BR];
        c.edges[BR] = c.edges[UR];
        c.edges[UR] = edge;
        return c;
    }
    Cube rPrime()
    {
        Cube c = new Cube(this);
        // Corners
        Piece corner = c.corners[URF];
        c.corners[URF] = c.corners[URB];
        c.corners[URB] = c.corners[DRB];
        c.corners[DRB] = c.corners[DRF];
        c.corners[DRF] = corner;
        c.updateCornerOrientation(URF,2);
        c.updateCornerOrientation(URB,1);
        c.updateCornerOrientation(DRF,1);
        c.updateCornerOrientation(DRB,2);
        // Edges
        Piece edge = c.edges[FR];
        c.edges[FR] = c.edges[UR];
        c.edges[UR] = c.edges[BR];
        c.edges[BR] = c.edges[DR];
        c.edges[DR] = edge;


        return c;

    }
    Cube r2()
    {
        Cube c = new Cube(this);
        // Corners
        c.swapC(URF,DRB);
        c.swapC(URB,DRF);
        // Edges
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
        c.updateCornerOrientation(ULF,1);
        c.updateCornerOrientation(DLF,2);
        c.updateCornerOrientation(DLB,1);
        c.updateCornerOrientation(ULB,2);
        // Edges
       Piece edge = c.edges[UL];
       c.edges[UL] = c.edges[BL];
       c.edges[BL] = c.edges[DL];
       c.edges[DL] = c.edges[FL];
       c.edges[FL] = edge;
        return c;
    }
    Cube lPrime()
    {
        Cube c = new Cube(this);
        // Corners;
        Piece corner = c.corners[ULB];
        c.corners[ULB] = c.corners[ULF];
        c.corners[ULF] = c.corners[DLF];
        c.corners[DLF] = c.corners [DLB];
        c.corners[DLB] = corner;
        c.updateCornerOrientation(ULF,1);
        c.updateCornerOrientation(DLF,2);
        c.updateCornerOrientation(DLB,1);
        c.updateCornerOrientation(ULB,2);
        // Edges
        Piece edge = c.edges[UL];
        c.edges[UL] = c.edges[FL];
        c.edges[FL] = c.edges[DL];
        c.edges[DL] = c.edges[BL];
        c.edges[BL] = edge;
        return c;
    }
    Cube l2()
    {
        Cube c = new Cube(this);
        //
        // Corners
        c.swapC(ULF,DLB);
        c.swapC(ULB,DLF);
        // Edges
        c.swapE(UL,DL);
        c.swapE(FL,BL);
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
