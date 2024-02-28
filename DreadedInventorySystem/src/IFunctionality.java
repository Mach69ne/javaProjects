public interface IFunctionality
{
    public boolean moveItemFromTo(IStorage fromStorage, IStorage toStorage, Item item);

    public Item[] getItemsFromStorage(IStorage storage);
}
