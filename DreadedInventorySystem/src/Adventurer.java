public class Adventurer implements IStorage
{
    private Item[] inventory;

    Adventurer()
    {
        inventory = new Item[20];
    }
    @Override
    public Item[] getItems()
    {
        return inventory;
    }

    @Override
    public void storeItem(Item item)
    {
        for (int i = 0; i < inventory.length; i++)
        {
            if (inventory[i] == null)
            {
                inventory[i] = item;
                break;
            }
        }
    }

    @Override
    public Item retrieveItem(String nameToSearchFor)
    {
        for (int i = 0; i < inventory.length; i++)
        {
            if (inventory[i].getName().equals(nameToSearchFor))
            {
                inventory[i] = null;
                return inventory[i];
            }
        }
        return null;
    }
}
