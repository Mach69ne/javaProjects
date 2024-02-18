import Pieces.Position;

public class InputManager
{
    private static final java.util.Scanner scanner = new java.util.Scanner(System.in);
    private static Position fromPosition;
    private static Position toPosition;

    InputManager()
    {
    }

    // To move you type the position of the piece, followed by the position to move to:
    // FX: e2 e4
    public static void handleInput() throws Exception
    {
        String input = scanner.nextLine();
        if (input.equals("restart"))
        {
            throw new Exception(input);
        }
        String[] positions = input.split(" ");
        if (positions.length != 2)
        {
            throw new IllegalArgumentException("Not a valid amount of positions were given");
        }
        for (int i = 0; i < positions.length; i++)
        {
            String s = positions[i];
            if (s.length() != 2)
            {
                throw new IllegalArgumentException("At least one of the positions arent possible");
            }
            int x = s.charAt(0) - 48;
            int y = s.charAt(1) - 48;
            if (x > 8)
            {
                x -= 49;
            }
            y -= 1;
            if (x < 0 || x > 8 || y < 0 || y > 8)
            {
                throw new IllegalArgumentException("Illegal characters involved in at least one of the moves");
            }

            if (i == 0)
            {
                fromPosition = new Position(x, y);
            }
            if (i == 1)
            {
                toPosition = new Position(x, y);
            }


        }

    }

    public static Position getFromPosition()
    {
        return fromPosition;
    }

    public static Position getToPosition()
    {
        return toPosition;
    }

}
