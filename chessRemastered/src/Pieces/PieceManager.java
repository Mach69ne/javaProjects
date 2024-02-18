package Pieces;

import java.util.Arrays;

public class PieceManager
{
    private static final Piece[][] board = new Piece[8][8];
    private Position whiteKing;
    private Position blackKing;

    public static void clearBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            Arrays.fill(board[i], null);
        }

    }

    public static void resetBoard()
    {
        clearBoard();
    }

    private static void placePieces()
    {
        boolean isWhite = true;
        for (int y = 0; y < board.length; y++)
        {
            for (int x = 0; x < board[y].length; x++)
            {
                if (y == 1 || y == 6)
                {
                    board[x][y] = new Pawn(isWhite, x, y);
                    continue;
                }
                //                if (x == 7 || x == 0)
                //                {
                //                    board[x][y] = new Rook(isWhite, x, y);
                //                }
                //                if (x == 1 || x == 6)
                //                {
                //                    board[x][y] = new Knight(isWhite, x, y);
                //                }
                //                if (x == 2 || x == 5)
                //                {
                //                    board[x][y] = new Bishop(isWhite, x, y);
                //                }


            }
            if (y > 2)
            {
                isWhite = false;
            }
        }
    }

    public static Piece pieceOnSquare(Position position)
    {
        return board[position.x()][position.y()];
    }

    public static void removePiece(Position position)
    {
        board[position.x()][position.y()] = null;
    }

    public static void addPiece(Piece piece, int x, int y)
    {
        board[x][y] = piece;
    }

    public static void printBoard()
    {
        StringBuilder printString = new StringBuilder();
        for (int i = 0; i < board.length; i++)
        {
            for (int k = 0; k < board[i].length; k++)
            {
                if (board[i][k] == null)
                {
                    printString.append(".");
                    continue;
                }
                printString.append(board[i][k].getSymbol());
            }
            System.out.println(printString);
            printString = new StringBuilder();
        }
    }

    public static void addPiece(Piece piece, Position position)
    {
        addPiece(piece, position.x(), position.y());
    }

    public static boolean isEmpty(Position position)
    {
        return board[position.x()][position.y()] == null;
    }

    public static boolean isSameColor(boolean movingPieceColor, Position position)
    {
        if (board[position.x()][position.y()] == null)
        {
            return false;
        }
        return board[position.x()][position.y()].isWhite() == movingPieceColor;
    }

    public static boolean isTileUnderThreat(Position position)
    {
        for (Piece[] rows : board)
        {
            for (Piece piece : rows)
            {
                if (piece.checkIfMoveIsLegal(position))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
