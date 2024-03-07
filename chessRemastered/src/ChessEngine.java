import Pieces.Piece;
import Pieces.PieceManager;
import Pieces.Position;

import java.util.ArrayList;

public class ChessEngine
{
    public static Move getBestMove(boolean isWhite)
    {
        Piece[][] originalBoard = PieceManager.getBoard();
        ArrayList<Move> legalMoves = getAllLegalMoves(isWhite);
        if (legalMoves.isEmpty())
        {
            return null;
        }
        double bestRating = 100.0;
        Move bestMove = null;
        for (int i = 0; i < legalMoves.size(); i++)
        {
            System.out.println("Calculating move " + i + " out of " + legalMoves.size());
            GameManager.tryMove(legalMoves.get(i));
            double rating = calculatePosition();
            if (rating < bestRating)
            {
                bestRating = rating;
                bestMove = legalMoves.get(i);
            }
            PieceManager.setBoard(originalBoard);
        }

        System.out.println(bestMove);
        return bestMove;
    }

    private static ArrayList<Move> getAllLegalMoves(boolean isWhite)
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
                        if (piece.isWhite() != isWhite)
                        {
                            continue;
                        }
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
}
