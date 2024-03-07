package Pieces;

public class Piece
{
    private final int worth;
    private final boolean isWhite;
    private Position position;
    private boolean hasMoved = false;

    public Piece(boolean isWhite, int x, int y, int worth)
    {
        this.worth = worth;
        this.isWhite = isWhite;
        this.position = new Position(x, y);
        PieceManager.addPiece(this, position);
    }

    public Piece(boolean isWhite, int x, int y, int worth, boolean updatePieceManager)
    {
        this.worth = worth;
        this.isWhite = isWhite;
        this.position = new Position(x, y);
        if (updatePieceManager)
        {
            PieceManager.addPiece(this, position);
        }
    }

    public boolean checkIfMoveIsLegal(Position position)
    {
        return !PieceManager.isSameColor(this.isWhite(), position);
    }

    public boolean isWhite()
    {
        return isWhite;
    }

    public int getWorth()
    {
        return this.worth;
    }

    public char getSymbol()
    {
        return '.';
    }

    public boolean getHasMoved()
    {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved)
    {
        this.hasMoved = hasMoved;
    }

    public Position getPosition()
    {
        return this.position;
    }


    public void setPosition(Position position)
    {
        PieceManager.removePiece(this.getPosition());
        this.position = position;
        PieceManager.addPiece(this, this.position);
        setHasMoved(true);
    }


}
