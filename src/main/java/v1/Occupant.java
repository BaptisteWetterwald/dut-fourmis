package v1;

public class Occupant
{
    private int x;
    private int y;

    public Occupant(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    @Override
    public String toString()
    {
        return ".";
    }
}
