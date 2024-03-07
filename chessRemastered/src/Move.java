import Pieces.Piece;
import Pieces.Position;

public record Move(Piece piece, Position toPos)
{
    public Move changePos(Position position)
    {
        return new Move(piece, position);
    }

    public Move changePiece(Piece piece)
    {
        return new Move(piece, toPos);
    }
}
