import Pieces.Piece;
import Pieces.PieceManager;

public class GameManager
{
    private static boolean whiteTurn = true;

    GameManager()
    {

        PieceManager.resetBoard();
    }

    public static boolean getWhiteTurn()
    {
        return whiteTurn;
    }

    public static boolean makeMove(Move move)
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
            piece.setPosition(move.toPos());
            whiteTurn = !whiteTurn;
            System.out.println(ChessEngine.calculatePosition());
            return true;
        }
        return false;
    }

}
