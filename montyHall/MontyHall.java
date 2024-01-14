class MontyHall 
{
    public static void main(String[] args)
    {
        Door[] doors = new Door[3];
        for (int i = 0; i < doors.length; i++)
        {
            doors[i] = new Door();
        }

        for (int i = 0; i < 100; i++)
        {
            Door[] doorArr = new Door[2];
            int counter = 0;
            int rng = (int) Math.round(Math.random()*2);
            doors[rng].mark();
            int initialGuess = (int) Math.round(Math.random()*2);

            while (doorArr[0] == null || doorArr[1] == null)
            {
                doorArr[counter] = 
            }
            

        }

    }    
}
