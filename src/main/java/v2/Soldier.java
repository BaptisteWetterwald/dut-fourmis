package v2;

import java.util.ArrayList;

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
        ArrayList<int[]> listeVoisins = getListeVoisins();

        //Liste triée, tous les déplacements sont valides
        if (listeVoisins.size() > 0)
        {
            int rdmIndex = GameController.rdm.nextInt(listeVoisins.size());
            this.deplacerVers(listeVoisins.get(rdmIndex)[0], listeVoisins.get(rdmIndex)[1]);
        }
    }

    @Override
    public void seDeplacer()
    {
        this.deplacementHasard();
    }
}
