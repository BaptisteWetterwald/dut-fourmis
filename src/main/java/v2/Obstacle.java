package v2;

public class Obstacle extends Occupant
{

    /**
     * Constructeur classe Obstacle
     *
     * @param x ligne d'apparition sur la grille
     * @param y colonne d'apparition sur la grille
     * @param graphe graphe concerné
     */
    public Obstacle(int x, int y, Graphe graphe)
    {
        super(x, y, graphe);
    }

}

