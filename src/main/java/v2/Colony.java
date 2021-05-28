package v2;

import java.util.ArrayList;

public class Colony extends Occupant
{

    private final int pheromoneDeposit;
    private final int foodWithdrawal;


    /**
     * Constructeur classe Colony
     *
     * @param x abscisse d'apparition sur la grille
     * @param y ordonnée d'apparition sur la grille
     * @param graphe graphe concerné
     */
    public Colony(int x, int y, Graphe graphe, int pheromoneDeposit, int foodWithdrawal)
    {
        super(x, y, graphe);
        graphe.getTabGrid()[x][y].add(new Queen(x, y, graphe, this));
        this.pheromoneDeposit = pheromoneDeposit;
        this.foodWithdrawal = foodWithdrawal;
    }

    /**
     * Retourne la reine de la colonie
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

    public int getFoodWithdrawal()
    {
        return this.foodWithdrawal;
    }

    public int getPheromoneDeposit()
    {
        return this.pheromoneDeposit;
    }
}
