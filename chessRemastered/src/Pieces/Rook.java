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
        if (this.getPosition().x() == position.x() && this.getPosition().y() == position.y())
        {
            return true;
        }
        super.checkIfMoveIsLegal(position);
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

    private boolean checkIfPathIsClear(Position position)
    {
        if (this.getPosition().x() > position.x())
        {
            position = new Position(position.x() + 1, position.y());
        }
        else if (this.getPosition().x() < position.x())
        {
            position = new Position(position.x() - 1, position.y());
        }
        else if (this.getPosition().y() > position.y())
        {
            position = new Position(position.x(), position.y() + 1);
        }
        else
        {
            position = new Position(position.x(), position.y() - 1);
        }
        if (!PieceManager.isEmpty(position))
        {
            return false;
        }
        return checkIfMoveIsLegal(position);
    }
}
