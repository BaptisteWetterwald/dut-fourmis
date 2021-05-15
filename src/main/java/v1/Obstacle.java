package v1;

public class Obstacle extends Occupant
{

    public Obstacle(int x, int y, Grid grid)
    {
        super(x, y, grid);
    }

    @Override
    public String toString()
    {
        return "X";
    }

}
