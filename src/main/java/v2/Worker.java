package v2;

import java.util.ArrayList;
import java.util.Collections;

public class Worker extends Ant
{

    private int carried;
    private ArrayList<int[]> listeCasesParcourues;

    public Worker(int x, int y, Graphe graphe, Colony colony)
    {
        super(x, y, graphe, colony);
        this.carried = 0;
        this.listeCasesParcourues = new ArrayList<>();
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

    private int[] getBestLocation()
    {
        int[] loc = new int[2]; //{x,y}

        ArrayList<int[]> listeVoisins = getListeVoisins();
        ArrayList<int[]> listeVoisinsNonParcourus = new ArrayList<>(listeVoisins);
        if (listeVoisinsNonParcourus.size() > 0)
        {
            for (int i=listeVoisinsNonParcourus.size()-1; i>=0; i--)
            {
                boolean found = false;
                for (int j=listeCasesParcourues.size()-1; j>=0 && !found; j--)
                    if (listeVoisinsNonParcourus.get(i)[0] == listeCasesParcourues.get(j)[0] && listeVoisinsNonParcourus.get(i)[1] == listeCasesParcourues.get(j)[1])
                    {
                        found = true;
                        listeVoisinsNonParcourus.remove(i);
                    }
            }
            //Liste propre avec au moins 1 voisin pas parcouru
            if (listeVoisinsNonParcourus.size() > 0)
            {
                //Trier avec comparator pour check les phéromones en pos x y
            }
            else if (listeVoisins.size() > 0) //Tous les voisins parcourus
            {
                int index = GameController.rdm.nextInt(listeVoisins.size());
                this.deplacerVers(listeVoisins.get(index)[0], listeVoisins.get(index)[1]); //Déplacement random
            }
            else
                loc = null;
        }

        return loc;
    }


    public ArrayList<int[]> getListeCasesParcourues()
    {
        return this.listeCasesParcourues;
    }
}
