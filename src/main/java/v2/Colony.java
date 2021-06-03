package v2;

import java.util.ArrayList;

public class Colony extends Occupant
{

    private final int pheromoneDeposit;
    private final int foodWithdrawal;


    /**
     * Constructeur classe Colony
     *
     * @param x ligne d'apparition sur la grille
     * @param y colonne d'apparition sur la grille
     * @param graphe graphe concerné
     */
    public Colony(int x, int y, Graphe graphe, int pheromoneDeposit, int foodWithdrawal)
    {
        super(x, y, graphe);
        Queen q = new Queen(x, y, graphe, this);
        graphe.getTabGrid()[x][y].add(q);
        this.getGraphe().getListFourmis().add(q);
        this.pheromoneDeposit = pheromoneDeposit;
        this.foodWithdrawal = foodWithdrawal;
    }

    /**
     * Retourne la fourmi reine de la colonie
     *
     * @return reine de la colonie
     */
    public Queen getReine()
    {
        ArrayList<Occupant> list = this.getGraphe().getTabGrid()[this.getX()][this.getY()];

        int i=0;
        boolean found = false;
        while (!found && i<list.size())
            if (list.get(i) instanceof Queen)
                found = true;
            else
                i++;
        return (Queen)list.get(i);
    }


    /**
     * Simple accesseur
     *
     * @return le paramètre indiquant la quantité de nourriture à retirer
     */
    public int getFoodWithdrawal()
    {
        return this.foodWithdrawal;
    }

    /**
     * Simple accesseur
     *
     * @return le paramètre indiquant la quantité de phéromone à déposer
     */
    public int getPheromoneDeposit()
    {
        return this.pheromoneDeposit;
    }
}
