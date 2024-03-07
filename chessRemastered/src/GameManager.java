import Pieces.Piece;
import Pieces.PieceManager;
import Pieces.Position;

public class GameManager
{
    private static final boolean checkMate = false;
    private static boolean whiteTurn = true;

    public static boolean getWhiteTurn()
    {
        return whiteTurn;
    }

    public static boolean makeMove(Move move)
    {
        if (isMoveLegal(move))
        {
            move.piece().setPosition(move.toPos());
            whiteTurn = !whiteTurn;
            System.out.println(ChessEngine.calculatePosition());
            return true;
        }
        return false;
    }

    public static boolean isMoveLegal(Move move)
    {
        Piece piece = move.piece();
        if (piece.isWhite() != whiteTurn)
        {
            return false;
        }
        if (piece.checkIfMoveIsLegal(move.toPos()))
        {
            if (piece.getPosition().equals(move.toPos()))
            {
                return false;
            }
            Piece pieceOnToSquare = PieceManager.pieceOnSquare(move.toPos());
            Position oldPosition = piece.getPosition();
            piece.setPosition(move.toPos());
            boolean isInCheck = !PieceManager.isInCheck(whiteTurn);
            resetMove(move, pieceOnToSquare, oldPosition);
            return isInCheck;
        }
        return false;
    }

    private static void resetMove(Move move, Piece pieceOnToSquare, Position oldSquare)
    {
        move.piece().setPosition(oldSquare);
        if (pieceOnToSquare != null)
        {
            pieceOnToSquare.setPosition(move.toPos());
        }
    }
}
