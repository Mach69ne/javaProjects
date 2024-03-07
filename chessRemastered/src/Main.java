import Pieces.Piece;
import Pieces.PieceManager;

import java.io.IOException;

/*
TO DO LIST: king can move into check by pawn



*/
public class Main
{

    public static void main(String[] args)
    {
        UI ui = null;
        try
        {
            ui = new UI();
        }
        catch (IOException e)
        {
            System.out.println("You don't have chess.png in your folder, dumbass");
        }
        if (ui == null)
        {
            return;
        }
        ui.update();
        boolean whiteTurn = true;
        PieceManager.resetBoard();
        while (true)
        {
            ui.update();


            try
            {
                if (ui.getMove().piece() == null || ui.getMove().toPos() == null || ui.getMove() == null)
                {
                    continue;
                }
                // Find piece on the working square, and try to move to target square
                Piece piece = ui.getMove().piece();
                if (piece == null)
                {
                    throw new IllegalArgumentException("That field is currently empty");
                }
                if (piece.isWhite() != whiteTurn)
                {
                    throw new IllegalArgumentException("You cannot move opponents piece");
                }
                if (piece.checkIfMoveIsLegal(ui.getMove().toPos()))
                {
                    piece.setPosition(ui.getMove().toPos());
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
                whiteTurn = true;
                continue;
            }
            /*
            boolean inCheck = PieceManager.isInCheck(whiteTurn);
                       if (inCheck)
                      {
                            PieceManager.undoMove();
                            continue;
                        }
            */
            whiteTurn = !whiteTurn;
            //System.out.println(ChessEngine.calculatePosition());
            //PieceManager.printBoard();

        }


    }
}