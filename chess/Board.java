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

    public boolean move(int startRow, int startCol, int endRow, int endCol) throws IllegalArgumentException
    {
        if (board[startRow][startCol].getColor() == board[endRow][endCol].getColor() && board[endRow][endCol].getSymbol() != '.')
        {
            throw new IllegalArgumentException("You cannot capture pieces of your own color!");
        }
        String[] possibleMoves = board[startRow][startCol].legalSquares(startRow, startCol).split(",");
        for (int i = 0; i < possibleMoves.length; i++)
        {
            System.out.println(possibleMoves[i]);
            int[]moveToCheck = parseMove(possibleMoves[i]);
            if(moveToCheck.length == 2)
            {
                System.out.println(moveToCheck[0]);
                System.out.println(moveToCheck[1]);
                if (endRow == moveToCheck[0] && endCol == moveToCheck[1])
                {
                    board[endRow][endCol] = board[startRow][startCol];
                    board[startRow][startCol] = new EmptyCell();
                    return true;
                }
            }
        }
        
        throw new IllegalArgumentException("You cannot move that piece here");
    }

    private static int[] parseMove(String move)
    {
        int[] moveArr = new int[2];
        System.out.println(move);
        String[] moveCordsArr = move.split(".");
        for (int i = 0; i < moveCordsArr.length; i++)
        {
            moveArr[i] = Integer.parseInt(moveCordsArr[i]);

        }
        return moveArr;
    }

}
