package v2;

import java.util.ArrayList;

public abstract class Ant extends Occupant
{
    private Colony colony;

    /**
     * Constructeur classe Ant
     *
     * @param x abscisse d'apparition sur la graphe
     * @param y ordonnée d'apparition sur la graphe
     * @param graphe graphe concerné
     */
    public Ant(int x, int y, Graphe graphe, Colony colony)
    {
        super(x, y, graphe);
        this.colony = colony;
    }

    /**
     * Méthode abstraite à redéfinir pour chaque sous-classe.
     * Simule un déplacement sur le graphe.
     */
    abstract void seDeplacer();

    /**
     * Déplace la fourmi vers la nouvelle position
     *
     * @param x abscisse après déplacement
     * @param y ordonnée après déplacement
     */
    public void deplacerVers(int x, int y)
    {
        this.getGraphe().getTabGrid()[x][y].add(this);
        this.getGraphe().getTabGrid()[this.getX()][this.getY()].remove(this);
        this.setX(x);
        this.setY(y);
    }


    /**
     * Simple accesseur
     *
     * @return la Colony à laquelle appartient la fourmi
     */
    public Colony getColony()
    {
        return this.colony;
    }


    /**
     * Retourne la liste des noeuds voisins possibles (ni obstacles ni hors du graphe)
     *
     * @return la liste des noeuds voisins possibles (ni obstacles ni hors du graphe), stockés sous la forme {x, y}
     */
    public ArrayList<int[]> getListeVoisins()
    {
        int x = this.getX();
        int y = this.getY();
        ArrayList<int[]> listeVoisins = new ArrayList<>();
        listeVoisins.add(new int[]{x-1, y});
        listeVoisins.add(new int[]{x+1, y});
        listeVoisins.add(new int[]{x, y-1});
        listeVoisins.add(new int[]{x, y+1});
        for (int i=listeVoisins.size()-1; i>=0; i--)
            if ( !this.getGraphe().deplacementValide( listeVoisins.get(i)[0], listeVoisins.get(i)[1] ) )
                listeVoisins.remove(i);
        return listeVoisins;
    }

    /**
     * Déplace la fourmi sur un voisin au hasard
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

}
