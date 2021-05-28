package v2;

public class Pheromone extends Occupant
{

    private int quantity;

    /**
     * Constructeur classe Pheromone
     *
     * @param x      abscisse d'apparition sur la grille
     * @param y      ordonnée d'apparition sur la grille
     * @param graphe graphe concerné
     */
    public Pheromone(int x, int y, Graphe graphe)
    {
        super(x, y, graphe);
        this.quantity = 0;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    public void setQuantity(int newQty)
    {
        this.quantity = newQty;
    }

    public void evaporate(int evapQty)
    {
        this.quantity -= evapQty;
    }
}
