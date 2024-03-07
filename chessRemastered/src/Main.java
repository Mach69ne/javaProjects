import Pieces.PieceManager;

import java.io.IOException;

/*
TO DO LIST: king can move into check by pawn



*/
public class Main
{
    public static void main(String[] args)
    {
        try
        {
            PieceManager.resetBoard();
            UI ui = new UI();
        }
        catch (IOException e)
        {
            System.out.println("You dont have the picture dumbass");
            throw new RuntimeException(e);
        }

    }
}