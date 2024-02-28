public class Chest implements IStorage
{
    private Item[] inventory;
    Chest()
    {
        inventory = new Item[37];
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
        return null;
    }
}
