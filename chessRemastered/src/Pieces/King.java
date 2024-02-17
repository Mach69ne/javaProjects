package Pieces;

public class King extends Piece
{
    public King(boolean white, int x, int y)
    {
        super(white,x,y);
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position)
    {
        // Check if move is one square from current position
        return Math.abs(super.getPosition().getX() - position.getX()) <= 1 && Math.abs(position.getY() - super.getPosition().getY()) <= 1;
    }
}
