import Pieces.*;

public class Main
{

    public static void main(String[] args)
    {

        // TO-DO Add pieces on corresponding squares
        new King(true, 0, 0);
        new Pawn(false, 0, 7);

        InputManager inputManager = new InputManager();


        while (true)
        {
            try
            {
                inputManager.handleInput();

                // Find piece on the working square, and try to move to square
                Piece piece = PieceManager.pieceOnSquare(inputManager.getFromPosition());
                if (piece == null)
                {
                    throw new IllegalArgumentException("That field is currently empty");
                }

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