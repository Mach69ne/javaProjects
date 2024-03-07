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
            if (ui.getMove() == null || ui.getMove().piece() == null || ui.getMove().toPos() == null)
            {
                continue;
            }

            // Find piece on the working square, and try to move to target square
            Piece piece = ui.getMove().piece();
            if (piece.isWhite() != whiteTurn)
            {
                continue;
            }
            if (piece.checkIfMoveIsLegal(ui.getMove().toPos()))
            {
                piece.setPosition(ui.getMove().toPos());
                whiteTurn = !whiteTurn;
                ui.setMove(null);
            }

            System.out.println(ChessEngine.calculatePosition());
            //PieceManager.printBoard();

        }


    }
}