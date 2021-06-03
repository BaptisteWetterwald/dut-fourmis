package v2;

import java.util.ArrayList;

public class Soldier extends Ant
{
    /**
     * Constructeur classe Soldier
     *
     * @param x ligne d'apparition sur le tableau
     * @param y colonne d'apparition sur le tableau
     * @param graphe graphe concerné par le placement
     */
    public Soldier(int x, int y, Graphe graphe, Colony colony)
    {
        super(x, y, graphe, colony);
    }



    /**
     * Redéfinition de la méthode seDeplacer() présente dans Ant
     */
    @Override
    public void seDeplacer()
    {
        this.deplacementHasard();
    }
}
