package v1;

import java.util.ArrayList;
import java.util.Random;

public class Soldat extends Fourmi
{
    public Soldat(int x, int y, Grid grid)
    {
        super(x, y, grid);
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

    @Override
    public String toString()
    {
        return "s";
    }
}
