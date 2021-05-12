package v1;

public class Obstacle extends Occupant
{

    public Obstacle(int x, int y)
    {
        super(x, y);
    }

    @Override
    public String toString()
    {
        return "X";
    }

}
