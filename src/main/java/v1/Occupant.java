package v1;

public class Occupant
{
    private int x;
    private int y;
    private Grid grid;

    public Occupant(int x, int y, Grid grid)
    {
        this.x = x;
        this.y = y;
        this.grid = grid;
    }

    public Grid getGrid()
    {
        return this.grid;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }
}
