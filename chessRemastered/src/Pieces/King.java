package Pieces;

public class King extends Piece
{
    public King(boolean isWhite, int x, int y)
    {
        super(isWhite, x, y);
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position) throws IllegalArgumentException
    {
        super.checkIfMoveIsLegal(position);

        // Check if the king would be threatened by moving
        // If not, throw IllegalArgumentException caught in Main

        if (PieceManager.isTileUnderThreat(isWhite(), position))
        {
            throw new IllegalArgumentException("That tile is unsafe");
        }

        // Check if move is one square from current position
        if (Math.abs(super.getPosition().x() - position.x()) <= 1 && Math.abs(position.y() - super.getPosition().y()) <= 1)
        {
            return true;
        }
        else
        {
            throw new IllegalArgumentException("The king cant move that far");
        }
    }

    @Override
    public char getSymbol()
    {
        return 'K';
    }
}
