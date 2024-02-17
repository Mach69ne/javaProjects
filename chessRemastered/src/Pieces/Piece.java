package Pieces;

public class Piece
{
    private Position position;
    private boolean white;

    public Piece(boolean white, int x, int y)
    {
        this.position = new Position(x,y);
    }

    public boolean checkIfMoveIsLegal(Position position)
    {
        return false;
    }
    public Position getPosition()
    {
        return this.position;
    }
    public void setPosition(Position position)
    {
        this.position = position;
    }

}
