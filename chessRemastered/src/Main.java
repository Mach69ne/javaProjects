import Pieces.Piece;
import Pieces.PieceManager;

public class Main
{

    public static void main(String[] args)
    {
        boolean whiteTurn = true;
        PieceManager.resetBoard();
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
                continue;
            }
            catch (Exception e)
            {
                PieceManager.resetBoard();
                continue;
            }
            //boolean inCheck = PieceManager.isInCheck(whiteTurn);
            //if (inCheck)
            //{
            //PieceManager.undoMove();
            //continue;
            //}
            whiteTurn = !whiteTurn;
            PieceManager.printBoard();

        }


    }
}