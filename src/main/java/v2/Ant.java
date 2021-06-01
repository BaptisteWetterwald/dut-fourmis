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

    public Colony getColony()
    {
        return this.colony;
    }

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

}
