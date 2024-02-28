class MatrixUtils
{
    public static int[][] createMatrix()
    {
        int randomInt = getRandomNumber();
        var matrix = new int[10000][10000];

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
        return (int) Math.round(Math.random() * 9 + 1);
    }
}