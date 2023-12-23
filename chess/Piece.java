public class Piece 
{
    private boolean white;
    private char symbol;

    public Piece(boolean white, char symbol)
    {
        this.white = white;
        this.symbol = symbol;
    }
    public boolean getColor()
    {
        return this.white;
    }

    public char getSymbol()
    {
        return this.symbol;
    }
    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }

    public String legalSquares(int row, int coloumn)
    {
        return "";
    }

}
