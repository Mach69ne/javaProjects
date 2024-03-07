package Pieces;

public class Pawn extends Piece
{
    private boolean hasMoved = false;

    public Pawn(boolean isWhite, int x, int y)
    {
        super(isWhite, x, y, 1);
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position)
    {
        super.checkIfMoveIsLegal(position);

        if (!this.hasMoved)
        {
            if (this.getPosition().x() == position.x())
            {
                if (isWhite() && position.y() == 3)
                {
                    return PieceManager.isEmpty(position);
                }
                else if (!isWhite() && position.y() == 4)
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
    public void setPosition(Position position)
    {
        this.hasMoved = true;
        super.setPosition(position);
    }

    @Override
    public char getSymbol()
    {
        return 'P';
    }
}
