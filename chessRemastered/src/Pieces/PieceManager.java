package Pieces;

import java.util.Arrays;

public class PieceManager
{
    //private static final Stack<Piece[][]> boardStack = new Stack<Piece[][]>();
    private static Piece[][] board = new Piece[8][8];
    private static Position whiteKingPosition;
    private static Position blackKingPosition;

    public static void resetBoard()
    {
        clearBoard();
        placePieces();
        printBoard();
    }

    public static void clearBoard()
    {
        for (int i = 0; i < board.length; i++)
        {
            Arrays.fill(board[i], null);
        }

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
                    new Pawn(isWhite, x, y);
                    continue;
                }
                if (y != 0 && y != 7)
                {
                    continue;
                }

                if (x == 0 || x == 7)
                {
                    new Rook(isWhite, x, y);
                }
                if (x == 1 || x == 6)
                {
                    new Knight(isWhite, x, y);
                }
                if (x == 2 || x == 5)
                {
                    new Bishop(isWhite, x, y);
                }
                if (x == 3)
                {
                    new Queen(isWhite, x, y);
                }
                if (x == 4)
                {
                    new King(isWhite, x, y);
                }


            }
            if (y > 4)
            {
                isWhite = false;
            }
        }
    }

    public static void printBoard()
    {
        StringBuilder printString = new StringBuilder();
        for (int i = 7; i >= 0; i--)
        {
            for (int k = 0; k < board[i].length; k++)
            {
                if (board[k][i] == null)
                {
                    printString.append(".");
                    continue;
                }
                printString.append(board[k][i].getSymbol());
            }
            System.out.println(printString);
            printString = new StringBuilder();
        }
    }

    public static Piece[][] getBoard()
    {
        return board;
    }

    public static void setBoard(Piece[][] newBoard)
    {
        board = newBoard;
    }

    public static Piece pieceOnSquare(Position position)
    {
        return board[position.x()][position.y()];
    }

    public static void removePiece(Position position)
    {
        board[position.x()][position.y()] = null;
    }

    public static void addPiece(Piece piece, Position position)
    {
        if (piece.getSymbol() == 'P')
        {
            if (piece.getPosition().y() == 7 || piece.getPosition().y() == 0)
            {
                piece = new Queen(piece.isWhite(), position.x(), position.y());
            }
        }
        addPiece(piece, position.x(), position.y());
    }

    public static void addPiece(Piece piece, int x, int y)
    {
        board[x][y] = piece;
    }

    static void setKingPosition(boolean isWhite, Position position)
    {
        if (isWhite)
        {
            whiteKingPosition = position;
        }
        else
        {
            blackKingPosition = position;
        }
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

    public static boolean isInCheck(boolean isWhite)
    {
        if (isWhite)
        {
            return isTileUnderThreat(true, whiteKingPosition);
        }
        else
        {
            return isTileUnderThreat(false, blackKingPosition);
        }
    }

    public static boolean isTileUnderThreat(boolean isWhite, Position position)
    {
        for (int i = 0; i < board.length; i++)
        {
            for (int k = 0; k < board[i].length; k++)
            {
                Piece piece = board[i][k];
                if (piece == null)
                {
                    continue;
                }
                if (piece.isWhite() == isWhite)
                {
                    continue;
                }
                if (piece.getSymbol() == 'K')
                {
                    if (Math.abs(piece.getPosition().x() - position.x()) <= 1 && Math.abs(piece.getPosition().y() - position.y()) <= 1)
                    {
                        return true;
                    }
                    continue;
                }
                if (piece.getSymbol() == 'P')
                {
                    if (piece.getPosition().x() == position.x())
                    {
                        continue;
                    }
                    if (Math.abs(piece.getPosition().x() - position.x()) <= 1)
                    {
                        if (piece.isWhite())
                        {
                            if (piece.getPosition().y() - position.y() == -1)
                            {
                                return true;
                            }
                        }
                        else if (piece.getPosition().y() - position.y() == 1)
                        {
                            return true;
                        }
                    }
                }
                if (piece.checkIfMoveIsLegal(position))
                {
                    return true;
                }

            }
        }
        return false;
    }


}
