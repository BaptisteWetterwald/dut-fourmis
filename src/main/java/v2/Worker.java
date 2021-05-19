package v2;

public class Worker extends Ant
{

    private int carried;

    Worker(int x, int y, Graphe graphe, Colony colony)
    {
        super(x, y, graphe, colony);
        this.carried = 0;
    }

    public void depositPheromone()
    {
        Colony col = this.getColony();
        int qty = col.getFoodDeposit();

        Pheromone phero = this.getGraphe().getPheromoneAt(this.getX(), this.getY());
        if (phero == null)
            phero = new Pheromone(this.getX(), this.getY(), this.getGraphe());

        if (this.carried >= qty)
        {
            this.carried -= qty;
            phero.setQuantity(phero.getQuantity() + qty);
        }
        else
        {
            this.carried = 0;
            phero.setQuantity(qty);
        }
    }

    public void withdrawPheromone()
    {
        Colony col = this.getColony();
        int qty = col.getFoodWithdrawal();

        Pheromone phero = this.getGraphe().getPheromoneAt(this.getX(), this.getY());
        if (phero == null)
            phero = new Pheromone(this.getX(), this.getY(), this.getGraphe());

        if (phero.getQuantity() >= qty)
        {
            this.carried += qty;
            phero.setQuantity(phero.getQuantity() - qty);
        }
        else
        {
            this.carried = phero.getQuantity();
            phero.setQuantity(0);
        }
    }

    @Override
    public void seDeplacer()
    {

    }

}
