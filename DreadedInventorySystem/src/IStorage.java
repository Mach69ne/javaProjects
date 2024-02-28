public interface IStorage
{
    public Item[] getItems();
    public void storeItem(Item item);

    public Item retrieveItem(String nameToSearchFor);
}
