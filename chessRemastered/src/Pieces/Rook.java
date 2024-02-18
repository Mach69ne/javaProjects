package Pieces;

public class Rook extends Piece
{
    public Rook(boolean isWhite, int x, int y)
    {
        super(isWhite, x, y);
    }

    @Override
    public char getSymbol()
    {
        return 'R';
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position) throws IllegalArgumentException
    {
        super.checkIfMoveIsLegal(position);

        if (this.getPosition().x() == position.x() && this.getPosition().y() == position.y())
        {
            return true;
        }

        if (this.getPosition().x() != position.x() && this.getPosition().y() != position.y())
        {
            return false;
        }

        int xIncrement = -1;
        int yIncrement = -1;
        if (this.getPosition().x() > position.x())
        {
            xIncrement = 1;
        }
        if (this.getPosition().y() > position.y())
        {
            yIncrement = 1;
        }
        if (this.getPosition().x() == position.x())
        {
            xIncrement = 0;
        }
        if (this.getPosition().y() == position.y())
        {
            yIncrement = 0;
        }

        return checkIfMoveIsLegal(new Position((this.getPosition().x() + xIncrement),
                this.getPosition().y() + yIncrement));
    }
}
