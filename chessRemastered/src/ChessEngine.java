import Pieces.Piece;
import Pieces.PieceManager;
import Pieces.Position;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChessEngine
{
    private static int depth = 0;
    private static Move bestMoveSoFar = null;
    private static double closestToZero = 1000000;
    public static Move getBestMove(boolean isWhite)
    {
        ArrayList<Move> legalMoves = getAllLegalMoves(isWhite);
        if (legalMoves.isEmpty())
        {
            return null;
        }
        double bestRating = 10000.0;
        Move bestMove = null;
        for (int i = 0; i < legalMoves.size(); i++)
        {
            System.out.println("Calculating move " + i + " out of " + legalMoves.size());
            Piece pieceToBeAffected = PieceManager.pieceOnSquare(legalMoves.get(i).toPos());
            Position oldPosition = legalMoves.get(i).piece().getPosition();
            boolean hasMoved = legalMoves.get(i).piece().getHasMoved();
            GameManager.makeMove(legalMoves.get(i));
            GameManager.setWhiteTurn(isWhite);
            double rating = calculatePosition();
            GameManager.resetMove(legalMoves.get(i),pieceToBeAffected,oldPosition);
            legalMoves.get(i).piece().setHasMoved(hasMoved);
            System.out.println(rating);
            if (rating < bestRating)
            {
                System.out.println(rating);
                bestRating = rating;
                bestMove = legalMoves.get(i);
            }
        }
        return bestMove;
    }


    private static ArrayList<Move> getAllLegalMoves(boolean isWhite)
    {
        ArrayList<Move> legalMoves = new ArrayList<>();
        for (int i = 0; i < 8; i++)
        {
            for (int k = 0; k < 8; k++)
            {
                Piece piece = PieceManager.pieceOnSquare(new Position(i, k));
                if (piece == null)
                {
                    continue;
                }
                if (piece.isWhite() != isWhite)
                {
                    continue;
                }
                for (int x = 0; x < 8; x++)
                {
                    for (int y = 0; y < 8; y++)
                    {

                        Move moveToCheck = new Move(piece, new Position(x, y));
                        if (GameManager.isMoveLegal(moveToCheck))
                        {
                            legalMoves.add(moveToCheck);
                        }

                    }
                }
            }
        }
        return legalMoves;
    }

    public static double calculatePosition()
    {
        double pieceWorthMultiplier = 1.0;


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
                    rating += piece.getWorth() * pieceWorthMultiplier;
                }
                else
                {
                    rating -= piece.getWorth() * pieceWorthMultiplier;
                }
            }
        }

        return rating;
    }
}
