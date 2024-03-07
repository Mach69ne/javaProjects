package Pieces;

public class Bishop extends Piece
{
    public Bishop(boolean isWhite, int x, int y)
    {
        super(isWhite, x, y, 3);
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position)
    {
        if (this.getPosition().equals(position))
        {
            return true;
        }
        if (!super.checkIfMoveIsLegal(position))
        {
            return false;
        }

        int deltaX = this.getPosition().x() - position.x();
        int deltaY = this.getPosition().y() - position.y();
        if (Math.abs(deltaX) < 1 && Math.abs(deltaY) < 1)
        {
            return true;
        }
        if (Math.abs(deltaX) != Math.abs(deltaY))
        {
            return false;
        }
        if (Math.abs(deltaX) == 1 && Math.abs(deltaY) == 1)
        {
            return true;
        }

        return checkIfPathIsClear(position);
    }

    @Override
    public char getSymbol()
    {
        return 'B';
    }

    private boolean checkIfPathIsClear(Position position)
    {
        if (getPosition().x() - position.x() > 0)
        {
            position = position.changeX(1);
        }
        else
        {
            position = position.changeX(-1);
        }
        if (getPosition().y() - position.y() > 0)
        {
            position = position.changeY(1);
        }
        else
        {
            position = position.changeY(-1);
        }
        if (!PieceManager.isEmpty(position))
        {
            return false;
        }
        return checkIfMoveIsLegal(position);
    }
}
