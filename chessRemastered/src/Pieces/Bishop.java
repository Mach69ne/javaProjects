package Pieces;

import javafx.geometry.Pos;

import javax.management.loading.ClassLoaderRepository;

public class Bishop extends Piece
{
    public Bishop(boolean isWhite, int x, int y)
    {
        super(isWhite,x,y);
    }

    @Override
    public boolean checkIfMoveIsLegal(Position position) throws IllegalArgumentException
    {
        return true;
    }

    @Override
    public char getSymbol()
    {
        return 'B';
    }
}
