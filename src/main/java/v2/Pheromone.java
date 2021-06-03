package v2;

public class Pheromone extends Occupant
{

    private int quantity;

    /**
     * Constructeur classe Pheromone
     *
     * @param x ligne d'apparition sur la grille
     * @param y colonne d'apparition sur la grille
     * @param graphe graphe concerné
     */
    public Pheromone(int x, int y, Graphe graphe)
    {
        super(x, y, graphe);
        this.quantity = 0;
    }


    /**
     * Simple accesseur
     *
     * @return la quantité de phéromone de l'instance
     */
    public int getQuantity()
    {
        return this.quantity;
    }

    /**
     * Simple mutateur
     * Définit la quantité de phéromone de l'instance à la quantité passée en paramètre
     *
     * @param newQty nouvelle quantité de phéromone
     */
    public void setQuantity(int newQty)
    {
        this.quantity = newQty;
    }

    /**
     * Simule le comportement de l'évaporation sur l'instance
     *
     * @param evapQty quantité de phéromone à retirer à l'instance
     */
    public void evaporate(int evapQty)
    {
        this.quantity -= evapQty;
    }
}
