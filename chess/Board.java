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
        
        return true;
    }

    private int[] parseMove(String move)
    {
        int[] moveArr = new int[2];
        
        String[] moveCordsArr = move.split(".");
        for (int i = 0; i < 3; i++)
        {
            moveArr[i] = Integer.parseInt(moveCordsArr[i]);
            
        }
        return moveArr;
    }

}
