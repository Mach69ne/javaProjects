public class Chess
{
    public static void main(String[] args)
    {
        var scanner = new java.util.Scanner(System.in);
        var board = new Board();

        board.viewBoard();


            try{
                int[] move = handleInput(scanner.nextLine());
                board.move(0, 4, 1, 5);
                
                board.viewBoard();
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }

        scanner.close();
    }

    private static int[] handleInput(String input) throws IllegalArgumentException
    {
        int[] cords = new int[2];
        String lettersOnBoard = "abcdefgh";
        if (input.length() == 2)
        {
            if (lettersOnBoard.indexOf(input.charAt(0)) == -1 || !Character.isDigit(input.charAt(1)))
            {
                throw new IllegalArgumentException("Your move does not follow standard chess notation!");
            }
            cords[0] = input.indexOf(input.charAt(0));
            return cords;
        }
        if (input.length() == 3)
        {

            return cords;
        }
        if (input.length() == 4)
        {
            return cords;
        }
        throw new IllegalArgumentException("Invalid Input");
    }
}