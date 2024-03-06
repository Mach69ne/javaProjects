package Pieces;

public class Queen extends Piece
{
    private final Rook rook;
    private final Bishop bishop;

    public Queen(boolean isWhite, int x, int y)
    {
        super(isWhite, x, y, 9);
        this.bishop = new Bishop(this.isWhite(), this.getPosition().x(), this.getPosition().y());
        this.rook = new Rook(this.isWhite(), this.getPosition().x(), this.getPosition().y());
        PieceManager.addPiece(this, x, y);
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position) throws IllegalArgumentException
    {
        super.checkIfMoveIsLegal(position);
        boolean returnStatement = false;
        rook.setPosition(this.getPosition());
        bishop.setPosition(this.getPosition());
        returnStatement |= rook.checkIfMoveIsLegal(position);
        returnStatement |= bishop.checkIfMoveIsLegal(position);
        this.setPosition(this.getPosition());
        return returnStatement;

    }

    @Override
    public char getSymbol()
    {
        return 'Q';
    }
}
