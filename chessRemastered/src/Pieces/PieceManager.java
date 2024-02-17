package Pieces;

public class PieceManager
{
    Piece[][] board;

    public PieceManager()
    {
        board = new Piece[8][8];
    }

    public Piece pieceOnSquare(int x, int y)
    {
        return board[x][y];
    }


}
