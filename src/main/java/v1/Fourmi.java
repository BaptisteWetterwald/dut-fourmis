package v1;

public abstract class Fourmi extends Occupant
{

    public Fourmi(int x, int y, Grid grid)
    {
        super(x, y, grid);
    }

    public void deplacerVers(int x, int y, Grid grid)
    {
        grid.getTabGrid()[x][y].add(this); //Déplacement de la fourmi dans la grille
        grid.getTabGrid()[this.getX()][this.getY()].remove(this); //On devra le changer pour la v2, en retirant la fourmi de la liste Occupant
        this.setX(x);
        this.setY(y);
    }

    public boolean deplacementValide(int newX, int newY, Grid grid)
    {
        boolean valide = true;

        //Si la case n'est pas dans la grille
        if (newX<0 || newX>=grid.getTabGrid()[0].length || newY<0 || newY>=grid.getTabGrid().length)
            valide = false;

        //Si la case contient un obstacle
        else
            for (int i = 0; i<grid.getTabGrid()[newX][newY].size() && valide; i++)
                if (grid.getTabGrid()[newX][newY].get(i) instanceof Obstacle)
                    valide = false;
        return valide;
    }

    @Override
    public String toString()
    {
        return "o";
    }
}
