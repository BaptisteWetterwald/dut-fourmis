package v2;

import java.util.ArrayList;

public class Colony extends Occupant
{
    public Colony(int rdmX, int rdmY, Grid grid)
    {
        super(rdmX, rdmY, grid);
        grid.getTabGrid()[rdmX][rdmY].add(new Queen(rdmX, rdmY, grid));
    }

    @Override
    public String toString()
    {
        return "F";
    }

    public Queen getReine()
    {
        ArrayList<Occupant> list = this.getGrid().getTabGrid()[this.getX()][this.getY()];
        int i=0;
        boolean found = false;
        while (!found && i<list.size())
        {
            if (list.get(i) instanceof Queen)
            {
                found = true;
            }
            else
                i++;
        }
        return (Queen)list.get(i);
    }
}
