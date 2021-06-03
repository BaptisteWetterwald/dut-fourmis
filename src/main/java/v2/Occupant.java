package v2;

public class Occupant
{
    private int x;
    private int y;
    private final Graphe graphe;

    /**
     * Constructeur classe Occupant
     *
     * @param x ligne d'apparition sur la grille
     * @param y colonne d'apparition sur la grille
     * @param graphe graphe concerné
     */
    public Occupant(int x, int y, Graphe graphe)
    {
        this.x = x;
        this.y = y;
        this.graphe = graphe;
    }

    /**
     * Simple accesseur
     * Retourne le graphe contenant l'occupant
     *
     * @return le graphe contenant l'occupant
     */
    public Graphe getGraphe()
    {
        return this.graphe;
    }

    /**
     * Simple accesseur
     * Retourne la ligne de l'occupant dans la grille
     *
     * @return la ligne de l'occupant dans le tableau
     */
    public int getX()
    {
        return this.x;
    }

    /**
     * Simple accesseur
     * Retourne la colonne de l'occupant dans la grille
     *
     * @return la colonne de l'occupant dans le tableau
     */
    public int getY()
    {
        return this.y;
    }

    /**
     * Simple mutateur
     * Modifie la ligne théorique attribuée à l'occupant
     *
     * @param x nouvelle ligne de l'occupant
     */
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * Simple mutateur
     * Modifie la colonne théorique attribuée à l'occupant
     *
     * @param y nouvelle colonne de l'occupant
     */
    public void setY(int y)
    {
        this.y = y;
    }
}
