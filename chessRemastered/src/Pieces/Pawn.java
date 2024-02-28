package Pieces;

public class Pawn extends Piece
{
    public Pawn(boolean isWhite, int x, int y)
    {
        super(isWhite, x, y);
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position) throws IllegalArgumentException
    {
        if (this.isWhite() && this.getPosition().x() == 2)
        {
            if (position.y() == 4)
            {
            }
        }
        super.checkIfMoveIsLegal(position);
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
                throw new IllegalArgumentException("Your pawn cant move in that direction");
            }
        }
        else
        {
            if (this.getPosition().y() - position.y() != 1)
            {
                throw new IllegalArgumentException("Your pawn cant move in that direction");
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
    public char getSymbol()
    {
        return 'P';
    }
}
