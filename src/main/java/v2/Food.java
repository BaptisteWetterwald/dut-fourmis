package v2;

public class Food extends Occupant
{

    private int quantity;

    /**
     * Constructeur classe Food
     *
     * @param x      abscisse d'apparition sur la grille
     * @param y      ordonnée d'apparition sur la grille
     * @param graphe graphe concerné
     */
    public Food(int x, int y, Graphe graphe)
    {
        super(x, y, graphe);
        this.quantity = 0;
    }


    /**
     * Simple accesseur
     *
     * @return la quantité de nourriture sur le noeud
     */
    public int getQuantity()
    {
        return this.quantity;
    }

    /**
     * Simple mutateur
     *
     * @param newQty nouvelle quantité de nourriture à mettre sur le noeud
     */
    public void setQuantity(int newQty)
    {
        this.quantity = newQty;
    }
}
