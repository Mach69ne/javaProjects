public class Functionality implements IFunctionality
{

    @Override
    public boolean moveItemFromTo(IStorage fromStorage, IStorage toStorage, Item item)
    {
        Item workingItem = fromStorage.retrieveItem(item.getName());
        toStorage.storeItem(workingItem);
        return true;
    }

    @Override
    public Item[] getItemsFromStorage(IStorage storage)
    {
        return new Item[0];
    }
}
