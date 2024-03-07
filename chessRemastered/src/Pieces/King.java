package Pieces;

public class King extends Piece
{
    public King(boolean isWhite, int x, int y)
    {
        super(isWhite, x, y, 0);
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position)
    {
        if (!super.checkIfMoveIsLegal(position))
        {
            return false;
        }

        // Check if the king would be threatened by moving
        // If not, throw IllegalArgumentException caught in Main

        if (PieceManager.isTileUnderThreat(isWhite(), position))
        {
            return false;
        }

        // Check if move is one square from current position
        return Math.abs(super.getPosition().x() - position.x()) <= 1 && Math.abs(position.y() - super.getPosition().y()) <= 1;
    }

    @Override
    public char getSymbol()
    {
        return 'K';
    }
}
