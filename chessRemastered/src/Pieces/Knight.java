package Pieces;

public class Knight extends Piece
{
    public Knight(boolean isWhite, int x, int y)
    {
        super(isWhite, x, y, 3);
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position)
    {
        super.checkIfMoveIsLegal(position);

        int deltaX = Math.abs(this.getPosition().x() - position.x());
        int deltaY = Math.abs(this.getPosition().y() - position.y());
        
        if (deltaX == 1 && deltaY == 2)
        {
            return true;
        }
        return deltaX == 2 && deltaY == 1;

    }

    @Override
    public char getSymbol()
    {
        return 'N';
    }
}
