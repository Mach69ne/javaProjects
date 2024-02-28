package Pieces;

public record Position(int x, int y)
{
    public Position changeX(int x)
    {
        return new Position(this.x() + x, this.y());
    }

    public Position changeY(int y)
    {
        return new Position(this.x(), this.y() + y);
    }

    public boolean equals(Position position)
    {
        return this.x() == position.x() && this.y() == position.y();
    }
}
