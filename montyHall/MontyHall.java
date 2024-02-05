class MontyHall 
{
    public static void main(String[] args)
    {
        for (int dean = 0; dean < 100; dean++)
        {

        
            int initGuess = 0;
            int switchGuess = 0;
            while (initGuess < 10000)
            {
                boolean[] doors = new boolean[3];
                for (int i = 0; i < doors.length; i++)
                {
                    doors[i] = false;
                }
                int correctDoor = getRandomDoor();
                doors[correctDoor] = true;
                int initialGuess = getRandomDoor();
                
                int removedDoor = getRandomDoor();
                while (removedDoor == correctDoor || removedDoor == initialGuess)
                {
                    removedDoor = getRandomDoor();
                }

                int doorToMoveTo = getRandomDoor();

                while (doorToMoveTo == initialGuess || doorToMoveTo == removedDoor)
                {
                    doorToMoveTo = getRandomDoor();
                }

                if (correctDoor == initialGuess)
                {
                    initGuess++;
                }
                else if (correctDoor == doorToMoveTo) 
                {
                    switchGuess++;
                }
            
            }


            System.out.println(initGuess + " " + switchGuess);
        }
    }

    private static int getRandomDoor() 
    {
        return (int)Math.round(Math.random() * 2);
    }
}
