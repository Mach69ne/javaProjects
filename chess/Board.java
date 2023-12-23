public class Board
{
    private Piece[][] board;
    public Board()
    {
        Piece[][] board = new Piece[8][8];
        for (int i = 0; i < 8; i++)
        {
            for (int k = 0; k < 8; k++)
            {
                    board[i][k] = new EmptyCell();
            }
        }
        boolean white = true;
        boolean creating = true;
        int workingRow = 0;
        // Creation of the backrank:
        while (creating)
        {

            board[workingRow][4] = new King(white);

            if (!white)
            {
                creating = false;
            }
            workingRow = 7;
            white = false;
        }
        
        
        this.board = board;
    }

    public void viewBoard()
    {
        String printStatement = "";

        for (int i = 0; i < 8; i++)
        {
            for (int k  = 0; k < 8; k++)
            {
                printStatement += board[i][k].getSymbol() + " ";
            }
            if (i != 7)
            {
                printStatement += "\n";
            }
        }

        System.out.println(printStatement);
    }

    public boolean move(int startRow, int startCol, int endRow, int endCol)
    {
        if (board[startRow][startCol].getColor() == board[endRow][endCol].getColor())
        {
            return false;
        }
        String[] possibleMoves = board[startRow][startCol].legalSquares(startRow, startCol).split(",");
        
        for (int i = 0; i < possibleMoves.length; i++)
        {
            int[]moveToCheck = parseMove(possibleMoves[i]);
            if(moveToCheck.length == 2)
            {
                if (endRow == moveToCheck[0] && endCol == moveToCheck[1])
                {
                    board[endRow][endCol] = board[startRow][startCol];
                    board[startRow][startCol] = new EmptyCell();
                    return true;
                }
            }
        }

        return false;
    }

    private static int[] parseMove(String move)
    {
        int[] moveArr = new int[2];
        
        String[] moveCordsArr = move.split(".");
        for (int i = 0; i < moveCordsArr.length; i++)
        {
            moveArr[i] = Integer.parseInt(moveCordsArr[i]);
        }
        return moveArr;
    }

}
