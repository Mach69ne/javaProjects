class Algos 
{
    public static long startFromMiddle(int[][] matrix)
    {
        long startTime = System.nanoTime();

        int middleIndex = (int) Math.floor(matrix.length / 2);
        
        System.out.println(findTop(matrix, middleIndex, middleIndex));

        return System.nanoTime() - startTime;
    }
    public static long findMaxInMiddle(int[][] matrix)
    {
        long startTime = System.nanoTime();
        int middleIndex = (int) Math.floor(matrix.length / 2);
        int maxIndex = 0;
        for (int i = 0; i < matrix.length; i++)
        {
            if (matrix[middleIndex][maxIndex] < matrix[middleIndex][i]) maxIndex = i;
        }
        System.out.println(findTop(matrix, middleIndex, maxIndex));
        return System.nanoTime() - startTime;
    }
    
    private static long findTop(int[][] matrix, int workingIndexX, int workingIndexY)
    {
        long amountOfTurns = 0;
        while (true)
        {
            amountOfTurns++;
            int value = matrix[workingIndexX][workingIndexY];
            
            if (workingIndexX - 1 >= 0)
            {
                if (value < matrix[workingIndexX-1][workingIndexY])
                {
                    workingIndexX--;
                    continue;
                }
            }
            if (workingIndexX + 1 <= matrix.length - 1)
            { 
                if (value < matrix[workingIndexX+1][workingIndexY])
                {
                    workingIndexX++;
                    continue;
                }
            }
            if (workingIndexY - 1 >= 0)
            {
                if (value < matrix[workingIndexX][workingIndexY - 1])
                {
                    workingIndexY--;
                    continue;
                }
            }
            if (workingIndexY + 1 <= matrix.length - 1)
            {
                if (value < matrix[workingIndexX][workingIndexY + 1])
                {
                    workingIndexY++;
                    continue;
                }
            }
            break;
        }
        return amountOfTurns;
    }

}