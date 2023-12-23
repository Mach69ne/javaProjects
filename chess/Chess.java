public class Chess
{
    public static void main(String[] args)
    {
        var board = new Board();

        board.viewBoard();

        while (true)
        {
            try{
                board.move(0, 4, 1, 5);
                board.viewBoard();
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }

        }
    }

    private static String translateMove()
    {
        
    }
}