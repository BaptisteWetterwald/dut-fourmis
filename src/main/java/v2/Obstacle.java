package v2;

public class Obstacle extends Occupant
{
    public Obstacle(int x, int y) {
        super(x, y);
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }
}
