class Main 
{
    public static void main(String[] args)
    {
        long startFromMiddle = 0;
        long findMaxInMiddle = 0;
        for (int i = 0; i < 5; i++)
        {
            var matrix = MatrixUtils.createMatrix();
            startFromMiddle += Algos.startFromMiddle(matrix);

            findMaxInMiddle += Algos.findMaxInMiddle(matrix);

            System.out.println("i " + i + System.lineSeparator());
        }

        System.out.println(startFromMiddle);
        System.out.println(findMaxInMiddle);
        
    }
}
