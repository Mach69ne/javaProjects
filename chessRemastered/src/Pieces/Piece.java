package Pieces;

public class Piece
{
    private Position position;
    private final boolean isWhite;

    public Piece(boolean isWhite, int x, int y)
    {
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

    public boolean isWhite()
    {
        return isWhite;
    }

}