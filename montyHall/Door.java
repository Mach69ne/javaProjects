class Door
{
    private boolean isDoor = false;

    public Door(){}

    public boolean check()
    {
        return this.isDoor;
    }
    public void reset()
    {
        this.isDoor = false;
    }
    public void mark()
    {
        this.isDoor = true;
    }

}