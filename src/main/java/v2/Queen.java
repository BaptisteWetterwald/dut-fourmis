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
    public Queen(int x, int y, Graphe graphe)
    {
        super(x, y, graphe);
    }

    /**
     * Donne vie à une nouvelle fourmi-soldat
     */
    public void donnerVie()
    {
        Soldier soldier = new Soldier(this.getX(), this.getY(), this.getGraphe());
        this.getGraphe().getTabGrid()[this.getX()][this.getY()].add(soldier);
        this.getGraphe().getListFourmis().add(soldier);
    }

}
