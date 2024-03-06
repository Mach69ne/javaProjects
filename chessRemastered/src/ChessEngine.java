import Pieces.Piece;
import Pieces.PieceManager;
import Pieces.Position;

import java.util.ArrayList;

public class ChessEngine
{
    public static double calculatePosition()
    {
        double rating = 0.0;
        for (int i = 0; i < 8; i++)
        {
            for (int k = 0; k < 8; k++)
            {
                Piece piece = PieceManager.pieceOnSquare(new Position(i, k));
                if (piece == null)
                {
                    continue;
                }
                if (piece.isWhite())
                {
                    rating += piece.getWorth();
                }
                else
                {
                    rating -= piece.getWorth();
                }
            }
        }

        return rating;
    }

    public static Move getBestMove()
    {
        Piece[][] originalPosition = PieceManager.getBoard().clone();
        ArrayList<Move> legalMoves = getAllLegalMoves();
        if (legalMoves.isEmpty())
        {
            return null;
        }
        Move bestMove = legalMoves.get(0);
        //PieceManager.setBoard(originalPosition);
        tryMove(bestMove);
        return bestMove;
    }

    private static ArrayList<Move> getAllLegalMoves()
    {
        ArrayList<Move> legalMoves = new ArrayList<Move>();
        for (int i = 0; i < 8; i++)
        {
            for (int k = 0; k < 8; k++)
            {
                for (int x = 0; x < 8; x++)
                {
                    for (int y = 0; y < 8; y++)
                    {
                        Piece piece = PieceManager.pieceOnSquare(new Position(i, k));
                        if (piece == null)
                        {
                            continue;
                        }
                        try
                        {
                            piece.checkIfMoveIsLegal(new Position(x, y));
                        }
                        catch (IllegalArgumentException e)
                        {
                            continue;
                        }
                        if (piece.checkIfMoveIsLegal(new Position(x, y)))
                        {
                            legalMoves.add(new Move(piece, new Position(x, y)));
                        }

                    }
                }
            }
        }
        return legalMoves;
    }

    private static void tryMove(Move move)
    {
        move.piece().setPosition(move.toPos());
    }
}
