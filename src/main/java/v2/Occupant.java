package v2;

public class Occupant
{
    private int x;
    private int y;
    private final Graphe graphe;

    /**
     * Constructeur classe Occupant
     *
     * @param x abscisse d'apparition sur la grille
     * @param y ordonnée d'apparition sur la grille
     * @param graphe graphe concerné
     */
    public Occupant(int x, int y, Graphe graphe)
    {
        this.x = x;
        this.y = y;
        this.graphe = graphe;
    }

    /**
     * Retourne le graphe contenant l'occupant
     *
     * @return le graphe contenant l'occupant
     */
    public Graphe getGraphe()
    {
        return this.graphe;
    }

    /**
     * Retourne l'abscisse de l'occupant dans la grille
     *
     * @return l'abscisse de l'occupant dans le tableau
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * Retourne l'ordonnée de l'occupant dans la grille
     *
     * @return l'ordonnée de l'occupant dans le tableau
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * Modifie l'abscisse théorique attribuée à l'occupant
     *
     * @param x nouvelle abscisse de l'occupant
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * Modifie l'ordonnée théorique attribuée à l'occupant
     *
     * @param y nouvelle ordonnée de l'occupant
     */
    public void setY(int y)
    {
        this.y = y;
    }
}
