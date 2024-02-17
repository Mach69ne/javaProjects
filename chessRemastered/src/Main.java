import Pieces.*;

public class Main
{

    public static void main(String[] args)
    {
        Piece workingPiece = null;
        Piece[] pieces = new Piece[16];
        
        // TO-DO Add pieces on corresponding squares

        King king = new King(true, 2, 2);
        pieces[0] = king;
        InputManager inputManager = new InputManager();
        while (true)
        {
            try
            {
                inputManager.handleInput();
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
                continue;
            }
            // Find piece on the working square, and try to move to square
            for (Piece piece : pieces)
            {
                if (piece == null)
                {
                    continue;
                }
                if (piece.getPosition().getX() == inputManager.getFromPosition().getX() && piece.getPosition().getY() == inputManager.getFromPosition().getY())
                {
                    if (piece.checkIfMoveIsLegal(inputManager.getToPosition()))
                    {
                        piece.setPosition(inputManager.getToPosition());
                        System.out.println("Moved piece");
                    }
                    else
                    {
                        System.out.println("That is not a legal move");
                    }
                    break;
                }
            }
            break;
        }

        // TEMPORARY, FOR TESTING

        for (Piece piece : pieces)
        {
            if (piece == null)
            {
                continue;
            }
            System.out.println(piece.getPosition().getX());
            System.out.println(piece.getPosition().getY());
        }


    }
}