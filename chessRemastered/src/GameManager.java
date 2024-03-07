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
        if (moveIsCastle(move))
        {
            System.out.println(castle(move));
        }
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
            boolean hasMoved = piece.getHasMoved();
            piece.setPosition(move.toPos());
            boolean isInCheck = !PieceManager.isInCheck(whiteTurn);
            resetMove(move, pieceOnToSquare, oldPosition);
            piece.setHasMoved(hasMoved);
            return isInCheck;
        }
        return false;
    }

    private static boolean moveIsCastle(Move move)
    {
        if (move.piece().isWhite() != whiteTurn)
        {
            return false;
        }
        if (move.piece().getSymbol() == 'K')
        {
            return Math.abs(move.toPos().x() - move.piece().getPosition().x()) == 2;
        }
        return false;
    }

    private static boolean castle(Move move)
    {
        Position rookPosition = null;
        boolean kingSide = move.toPos().x() > 5;
        if (PieceManager.isInCheck(whiteTurn))
        {
            return false;
        }
        if (kingSide)
        {
            rookPosition = new Position(7, move.toPos().y());
        }
        else
        {
            rookPosition = new Position(0, move.toPos().y());
        }
        Piece rook = PieceManager.pieceOnSquare(rookPosition);
        Position positionToCheck = new Position(move.piece().getPosition().x(), move.piece().getPosition().y());
        if (rook.getSymbol() != 'R')
        {
            return false;
        }
        boolean piecesBlocking = true;
        if (kingSide)
        {
            if (isMoveLegal(new Move(rook, move.piece().getPosition().changeX(1))) && PieceManager.isEmpty(move.piece().getPosition().changeX(1)))
            {
                piecesBlocking = false;
            }
        }
        else
        {
            if (isMoveLegal(new Move(rook, move.piece().getPosition().changeX(-1))) && PieceManager.isEmpty(move.piece().getPosition().changeX(-1)))
            {
                piecesBlocking = false;
            }
        }
        return !piecesBlocking;
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
