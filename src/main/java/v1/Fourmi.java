package v1;

import java.util.ArrayList;
import java.util.Random;

public class Fourmi extends Occupant
{
    public Fourmi(int x, int y)
    {
        super(x, y);
    }

    public void deplacementHasard(Grid grid)
    {
        int x = this.getX();
        int y = this.getY();
        ArrayList<int[]> listeVoisins = new ArrayList<int[]>();
        listeVoisins.add(new int[]{x-1, y});
        listeVoisins.add(new int[]{x+1, y});
        listeVoisins.add(new int[]{x, y-1});
        listeVoisins.add(new int[]{x, y+1});
        for (int i=listeVoisins.size()-1; i>=0; i--)
            if ( !deplacementValide(listeVoisins.get(i)[0], listeVoisins.get(i)[1], grid) )
                listeVoisins.remove(i);

        //Liste triée, déplacements valides
        if (listeVoisins.size() > 0)
        {
            Random rdm = new Random();
            int rdmIndex = rdm.nextInt(listeVoisins.size());
            deplacerVers(listeVoisins.get(rdmIndex)[0], listeVoisins.get(rdmIndex)[1], grid);
        }
    }

    public void deplacerVers(int x, int y, Grid grid)
    {
        grid.getGrid()[this.getX()][this.getY()].remove(this); //On devra le changer pour la v2, en retirant la fourmi de la liste Occupant
        grid.getGrid()[x][y].add(this); //Déplacement de la fourmi dans la grille
        this.setX(x);
        this.setY(y);
    }

    public boolean deplacementValide(int newX, int newY, Grid grid)
    {
        boolean valide = true;
        if (newX<0 || newX>grid.getGrid()[0].length || newY<0 || newY>grid.getGrid().length)
            for (int i=0; i<grid.getGrid()[newX][newY].size() && valide; i++)
                if (grid.getGrid()[newX][newY].get(i) instanceof Obstacle)
                    valide = false;
        return valide;
    }

    @Override
    public String toString()
    {
        return "o";
    }
}
