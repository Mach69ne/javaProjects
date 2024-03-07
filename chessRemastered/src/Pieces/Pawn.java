package Pieces;

public class Pawn extends Piece
{

    public Pawn(boolean isWhite, int x, int y)
    {
        super(isWhite, x, y, 1);
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position)
    {
        if (!super.checkIfMoveIsLegal(position))
        {
            return false;
        }

        if (!this.getHasMoved())
        {
            if (this.getPosition().x() == position.x())
            {
                if (isWhite() && position.y() == 3 && PieceManager.isEmpty(new Position(position.x(), 2)))
                {
                    return PieceManager.isEmpty(position);
                }
                else if (!isWhite() && position.y() == 4 && PieceManager.isEmpty(new Position(position.x(), 5)))
                {
                    return PieceManager.isEmpty(position);
                }
            }
        }

        if (this.getPosition().x() == position.x() && !PieceManager.isEmpty(position))
        {
            return false;
        }
        if (this.getPosition().x() != position.x() && PieceManager.isEmpty(position))
        {
            return false;
        }


        if (this.isWhite())
        {
            if (this.getPosition().y() - position.y() != -1)
            {
                return false;
            }
        }
        else
        {
            if (this.getPosition().y() - position.y() != 1)
            {
                return false;
            }
        }

        return Math.abs(this.getPosition().x() - position.x()) <= 1;
    }

    @Override
    public char getSymbol()
    {
        return 'P';
    }
}
