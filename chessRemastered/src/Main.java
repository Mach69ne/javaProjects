import Pieces.PieceManager;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            PieceManager.resetBoard();
            UI ui = new UI();
            if (GameManager.isBotToPlay())
            {
                GameManager.botMakeMove();
            }
        }
        catch (IOException e)
        {
            System.out.println("You don't have the picture dumbass");
            throw new RuntimeException(e);
        }

    }
}