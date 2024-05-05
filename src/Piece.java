public class Piece
{
    // 0-11 za ivice, 0-7 za coskove
    public int index;

    // 0-1 za ivice, 0-2 za coskove
    public int orientation;

    public Piece(int index, int orientation)
    {
        this.index = index;
        this.orientation = orientation;
    }

    public int getIndex() {
        return index;
    }

    public int getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        return "Piece[" +getIndex()+"] - orientation: " + getOrientation();
    }
}
