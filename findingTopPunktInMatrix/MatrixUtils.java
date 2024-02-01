class MatrixUtils
{
    public static int[][] createMatrix()
    {
        int randomInt = getRandomNumber();
        var matrix = new int[randomInt][randomInt];

        for (int i = 0; i < matrix.length; i++)
        {
            for (int k = 0; k < matrix[i].length; k++)
            {
                matrix[i][k] = getRandomNumber();
            }
        }

        return matrix;
    }

    private static int getRandomNumber()
    {
        return (int) Math.round(Math.random() * 100 + 1);
    }
}