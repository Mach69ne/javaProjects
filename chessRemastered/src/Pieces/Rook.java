package Pieces;

public class Rook extends Piece
{
    public Rook(boolean isWhite, int x, int y)
    {
        super(isWhite, x, y, 5);
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
        if (this.getPosition().x() != position.x() && this.getPosition().y() != position.y())
        {
            return false;
        }
        else if (Math.abs(this.getPosition().x() - position.x()) == 1 || Math.abs(this.getPosition().y() - position.y()) == 1)
        {
            return true;
        }
        else
        {
            return checkIfPathIsClear(position);
        }
    }

    @Override
    public char getSymbol()
    {
        return 'R';
    }

    private boolean checkIfPathIsClear(Position position)
    {
        if (this.getPosition().x() > position.x())
        {
            position = position.changeX(1);
        }
        else if (this.getPosition().x() < position.x())
        {
            position = position.changeX(-1);
        }
        else if (this.getPosition().y() > position.y())
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
