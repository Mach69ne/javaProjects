public class Chess
{
    public static void main(String[] args)
    {
        var board = new Board();

        board.viewBoard();

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