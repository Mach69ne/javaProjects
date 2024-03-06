package Pieces;

public class Pawn extends Piece
{
    private boolean hasMoved = false;

    public Pawn(boolean isWhite, int x, int y)
    {
        super(isWhite, x, y, 1);
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position) throws IllegalArgumentException
    {
        super.checkIfMoveIsLegal(position);

        if (!this.hasMoved)
        {
            System.out.println(position.x() + " " + position.y());
            System.out.println(this.getPosition().x() + " " + this.getPosition().y());
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
            throw new IllegalArgumentException("Cant capture pieces non-diagonally");
        }
        if (this.getPosition().x() != position.x() && PieceManager.isEmpty(position))
        {
            throw new IllegalArgumentException("Your pawn cannot move in that direction, " + "as you are trying to " + "capture the air");
        }


        if (this.isWhite())
        {
            if (this.getPosition().y() - position.y() != -1)
            {
                throw new IllegalArgumentException("You cant move to that tile");
            }
        }
        else
        {
            if (this.getPosition().y() - position.y() != 1)
            {
                throw new IllegalArgumentException("You cant move to that tile");
            }
        }

        if (Math.abs(this.getPosition().x() - position.x()) <= 1)
        {
            return true;
        }
        else
        {
            throw new IllegalArgumentException("Cannot capture piece more than 1 tile away");
        }
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
