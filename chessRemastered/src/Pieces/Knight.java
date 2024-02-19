package Pieces;

public class Knight extends Piece
{
    public Knight(boolean isWhite, int x, int y)
    {
        super(isWhite,x,y);
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position) throws IllegalArgumentException
    {
        super.checkIfMoveIsLegal(position);

        int deltaX = Math.abs(this.getPosition().x() - position.x());
        int deltaY = Math.abs(this.getPosition().y() - position.y());

        if (deltaX == 1 && deltaY != 2) return false;
        if (deltaX == 2 && deltaY != 1) return false;

        return true;

    }
}
