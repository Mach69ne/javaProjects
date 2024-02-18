import Pieces.*;

public class Main
{

    public static void main(String[] args)
    {

        PieceManager.clearBoard();
        //InputManager inputManager = new InputManager();


        while (true)
        {
            try
            {
                InputManager.handleInput();

                // Find piece on the working square, and try to move to target square
                Piece piece = PieceManager.pieceOnSquare(InputManager.getFromPosition());
                if (piece == null)
                {
                    throw new IllegalArgumentException("That field is currently empty");
                }

                if (piece.checkIfMoveIsLegal(InputManager.getToPosition()))
                {
                    piece.setPosition(InputManager.getToPosition());
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
            catch (Exception e)
            {
                PieceManager.resetBoard();
            }
            PieceManager.printBoard();
        }


    }
}