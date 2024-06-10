public class Piece
{
    public int index;

    public int orientation;

    public Piece(int index, int orientation)
    {
        this.index = index;
        this.orientation = orientation;
    }
    public Piece(Piece p){

        this.index = p.index;
        this.orientation = p.orientation;
    }
    @Override
    public String toString() {
        return "Piece[" +index+"] - orientation: " + orientation;
    }
}