public class Item
{
    private final String name;
    private final int weight;

    Item(String name, int weight)
    {
        this.weight = weight;
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }
    public int getWeight()
    {
        return this.weight;
    }
}
