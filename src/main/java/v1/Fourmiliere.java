package v1;

import java.util.ArrayList;

public class Fourmiliere extends Occupant
{
    public Fourmiliere(int rdmX, int rdmY, Grid grid)
    {
        super(rdmX, rdmY, grid);
        grid.getTabGrid()[rdmX][rdmY].add(new Reine(rdmX, rdmY, grid));
    }

    @Override
    public String toString()
    {
        return "F";
    }

    public Reine getReine()
    {
        ArrayList<Occupant> list = this.getGrid().getTabGrid()[this.getX()][this.getY()];
        int i=0;
        boolean found = false;
        while (!found && i<list.size())
        {
            if (list.get(i) instanceof Reine)
            {
                found = true;
            }
            else
                i++;
        }
        return (Reine)list.get(i);
    }
}
