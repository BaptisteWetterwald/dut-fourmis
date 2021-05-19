package v2;

public class Queen extends Ant
{
    /**
     * Constructeur classe Queen
     *
     * @param x abscisse d'apparition sur la grille
     * @param y ordonnée d'apparition sur la grille
     * @param graphe graphe concerné
     */
    public Queen(int x, int y, Graphe graphe, Colony colony)
    {
        super(x, y, graphe, colony);
    }

    /**
     * Donne vie à une nouvelle fourmi-soldat
     */
    public void donnerVie(Class c)
    {
        Ant ant;
        if (c == Soldier.class)
            ant = new Soldier(this.getX(), this.getY(), this.getGraphe(), this.getColony());
        else
            ant = new Worker(this.getX(), this.getY(), this.getGraphe(), this.getColony());
        this.getGraphe().getTabGrid()[this.getX()][this.getY()].add(ant);
        this.getGraphe().getListFourmis().add(ant);
    }

}
