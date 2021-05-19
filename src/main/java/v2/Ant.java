package v2;

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

    public void seDeplacer(){}

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
     * Définit la validité d'un déplacement selon son occupation
     *
     * @param x abscisse de la nouvelle position à tester
     * @param y ordonnée de la nouvelle position à tester
     * @return true si le déplacement est valide, false sinon
     */
    public boolean deplacementValide(int x, int y)
    {
        boolean valide = true;

        //Si la case n'est pas dans la grille
        if (x<0 || x>=this.getGraphe().getTabGrid().length || y<0 || y>=this.getGraphe().getTabGrid()[0].length)
            valide = false;

        //Si la case contient un obstacle
        else
            for (int i = 0; i<this.getGraphe().getTabGrid()[x][y].size() && valide; i++)
                if (this.getGraphe().getTabGrid()[x][y].get(i) instanceof Obstacle)
                    valide = false;
        return valide;
    }

    public Colony getColony()
    {
        return this.colony;
    }

}
