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
        Position incrementingPosition = new Position(this.getPosition().x(), this.getPosition().y());
        int workingXValue = this.getPosition().x();
        if (this.getPosition().x() != position.x())
        {
            int increment = -1;
            if (this.getPosition().x() > position.x())
            {
                increment = 1;
            }
            while (incrementingPosition.x() != position.x())
            {
                incrementingPosition = new Position(increment + incrementingPosition.x(), position.y());
                if (!PieceManager.isEmpty(incrementingPosition))
                {
                    return false;
                }
            }
        }
        else if (this.getPosition().y() != position.y())
        {
            int increment = -1;
            if (this.getPosition().y() > position.y())
            {
                increment = 1;
            }
            while (incrementingPosition.y() != position.y())
            {
                incrementingPosition = new Position(position.x(), incrementingPosition.y() + increment);
                if (!PieceManager.isEmpty(incrementingPosition))
                {
                    return false;
                }
            }
        }
        return true;
        //return this.getPosition().x() != position.x() || this.getPosition().y() != position.y();

    }
}
