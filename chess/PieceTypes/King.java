public class King extends Piece
{
    public King(boolean white)
    {
        super(white,'k');

        if (white)
        {
            super.setSymbol('K');
        }
    }


    @Override
    public String legalSquares(int row, int coloumn)
    {
        String returnString = "";
        for (int i = 0; i < 8; i++)
        {
            for (int k = 0; k < 8; k++)
            {
                if (i > 0 && i < 8 && k > 0 && k < 8 )
                {
                    if (Math.abs(row-i) <= 1 && Math.abs(coloumn-k) <= 1 )
                    returnString += i + "." + k + ",";
                }
            }
        }
        return returnString;
    }

    
}