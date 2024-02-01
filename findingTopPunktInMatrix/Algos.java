class Algos 
{
    public static long startFromMiddle(int[][] matrix)
    {
        long startTime = System.nanoTime();

        int middleIndex = (int) Math.floor(matrix.length / 2);
        int workingIndexX = middleIndex;
        int workingIndexY = middleIndex;

        while (true)
        {
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
        return System.nanoTime() - startTime;
    } 
}