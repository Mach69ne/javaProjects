import Pieces.*;

public class Main
{

    public static void main(String[] args)
    {

        // TO-DO Add pieces on corresponding squares
        King king = new King(true, 2, 2);
        Pawn pawn = new Pawn(false, 3, 3);

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
            Piece piece = PieceManager.pieceOnSquare(inputManager.getFromPosition());
            if (piece == null)
            {
                System.out.println("That field is currently empty");
                continue;
            }
            try
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
            }
            catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            }
            PieceManager.printBoard();
        }


    }
}