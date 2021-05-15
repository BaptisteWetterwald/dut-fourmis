package v1;

public class Queen extends Ant
{
    public Queen(int x, int y, Grid grid)
    {
        super(x, y, grid);
    }

    public void donnerVie()
    {
        Soldier soldier = new Soldier(this.getX(), this.getY(), this.getGrid());
        this.getGrid().getTabGrid()[this.getX()][this.getY()].add(soldier);
        this.getGrid().getListFourmis().add(soldier);
    }

    @Override
    public String toString()
    {
        return "r";
    }
}
