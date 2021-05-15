package v1;

public class Reine extends Fourmi
{
    public Reine(int x, int y, Grid grid)
    {
        super(x, y, grid);
    }

    public void donnerVie()
    {
        Soldat soldat = new Soldat(this.getX(), this.getY(), this.getGrid());
        this.getGrid().getTabGrid()[this.getX()][this.getY()].add(soldat);
        this.getGrid().getListFourmis().add(soldat);
    }

    @Override
    public String toString()
    {
        return "r";
    }
}
