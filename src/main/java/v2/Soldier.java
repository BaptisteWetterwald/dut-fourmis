package v2;

import java.util.ArrayList;
import java.util.Random;

public class Soldier extends Ant
{
    /**
     * Constructeur classe Soldier
     *
     * @param x abscisse d'apparition sur le tableau
     * @param y ordonnée d'apparition sur le tableau
     * @param graphe grille concernée par le placement
     */
    public Soldier(int x, int y, Graphe graphe, Colony colony)
    {
        super(x, y, graphe, colony);
    }

    /**
     * Fait se déplacer au hasard la fourmi-soldat
     */
    public void deplacementHasard()
    {
        int x = this.getX();
        int y = this.getY();
        ArrayList<int[]> listeVoisins = new ArrayList<int[]>();
        listeVoisins.add(new int[]{x-1, y});
        listeVoisins.add(new int[]{x+1, y});
        listeVoisins.add(new int[]{x, y-1});
        listeVoisins.add(new int[]{x, y+1});
        for (int i=listeVoisins.size()-1; i>=0; i--)
            if ( !deplacementValide( listeVoisins.get(i)[0], listeVoisins.get(i)[1] ) )
                listeVoisins.remove(i);

        //Liste triée, tous les déplacements sont valides
        if (listeVoisins.size() > 0)
        {
            Random rdm = new Random();
            int rdmIndex = rdm.nextInt(listeVoisins.size());
            deplacerVers(listeVoisins.get(rdmIndex)[0], listeVoisins.get(rdmIndex)[1]);
        }
    }

    @Override
    public void seDeplacer()
    {
        this.deplacementHasard();
    }
}
