package Pieces;

public class Piece
{
    private final boolean isWhite;
    private final int worth;
    private Position position;

    public Piece(boolean isWhite, int x, int y, int worth)
    {
        this.worth = worth;
        this.isWhite = isWhite;
        this.position = new Position(x, y);
        PieceManager.addPiece(this, x, y);
    }

    public boolean checkIfMoveIsLegal(Position position) throws IllegalArgumentException
    {
        if (PieceManager.isSameColor(this.isWhite(), position))
        {
            throw new IllegalArgumentException("Your own piece is in the way");
        }

        return true;
    }

    public boolean isWhite()
    {
        return isWhite;
    }

    public int getWorth()
    {
        return this.worth;
    }

    public Position getPosition()
    {
        return this.position;
    }

    public void setPosition(Position position)
    {
        PieceManager.removePiece(this.position);
        this.position = position;
        PieceManager.addPiece(this, this.position);
    }

    public char getSymbol()
    {
        return '.';
    }

}
