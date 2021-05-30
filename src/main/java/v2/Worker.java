package v2;

import java.util.ArrayList;

public class Worker extends Ant
{

    //TAKE FOOD ET EVAP pour reset la liste phero + kill les instances, + chercher les instanciations pour les ajouter à la liste

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
        int qty = this.getColony().getPheromoneDeposit();

        Pheromone phero = this.getGraphe().getPheromoneAt(this.getX(), this.getY());
        if (phero == null)
        {
            phero = new Pheromone(this.getX(), this.getY(), this.getGraphe());
            this.getGraphe().getTabGrid()[this.getX()][this.getY()].add(phero);
            this.getGraphe().getListPheromones().add(phero);
        }

        phero.setQuantity(phero.getQuantity() + qty);
    }

    public void takeFood()
    {
        Colony col = this.getColony();
        int qty = col.getFoodWithdrawal();

        Food food = this.getGraphe().getFoodAt(this.getX(), this.getY());
        if (food == null)
            food = new Food(this.getX(), this.getY(), this.getGraphe());

        if (food.getQuantity() >= qty)
        {
            this.carried += qty;
            food.setQuantity(food.getQuantity() - qty);
        }
        else
        {
            this.carried = food.getQuantity();
            food = null;
        }
    }

    @Override
    public void seDeplacer()
    {
        if (this.carried == 0)
        {
            ArrayList<int[]> listeVoisins = this.getListeVoisins();
            //listeVoisins.removeIf(tab -> this.getGraphe().contientNourriture(tab[0], tab[1])); //Enlève les voisins qui ne contiennent pas de nourriture
            int[] newLoc = new int[2];
            if (listeVoisins.size() > 1)
                newLoc = this.getBestLocation();

            else if (listeVoisins.size() == 1)
            {
                newLoc[0] = listeVoisins.get(0)[0];
                newLoc[1] = listeVoisins.get(0)[1];
            }

            if (listeVoisins.size() > 0) //S'il y a bien une position correcte
            {
                this.deplacerVers(newLoc[0], newLoc[1]);

                //Gestion nourriture + cases parcourues
                if (!getGraphe().contientNourriture(this.getX(), this.getY()))
                    this.listeCasesParcourues.add(new int[]{this.getX(), this.getY()});
                else
                    this.takeFood();
            }
        }
        else
        {
            if (this.getX()==this.getColony().getX() && this.getY()==this.getColony().getY())
            {
                this.listeCasesParcourues = new ArrayList<>();
                this.listeCasesParcourues.add(new int[]{this.getX(), this.getY()});
                this.depositAllFood();
            }

            else
                this.depositPheromone();

            if (this.listeCasesParcourues.size() > 0)
            {
                this.deplacerVers(this.listeCasesParcourues.get(this.listeCasesParcourues.size()-1)[0], this.listeCasesParcourues.get(this.listeCasesParcourues.size()-1)[1]);
                this.listeCasesParcourues.remove(this.listeCasesParcourues.size()-1);
            }

        }

    }

    private void depositAllFood()
    {
        this.getGraphe().putFood(this.getX(), this.getY(), this.carried);
        this.carried = 0;
    }

    private int[] getBestLocation()
    {
        int[] loc = new int[2]; //{x,y}

        ArrayList<int[]> listeVoisins = this.getListeVoisins();
        //ArrayList<int[]> listeVoisinsNonParcourus = new ArrayList<>(listeVoisins);
        if (listeVoisins.size() > 0)
        {

            //On enlève les positions parcourues
            for (int i=listeVoisins.size()-1; i>=0; i--)
            {
                boolean found = false;
                for (int j=this.listeCasesParcourues.size()-1; j>=0 && !found; j--)
                    if (listeVoisins.get(i)[0] == listeCasesParcourues.get(j)[0] && listeVoisins.get(i)[1] == listeCasesParcourues.get(j)[1])
                    {
                        found = true;
                        listeVoisins.remove(i);
                    }
            }

            //Liste propre avec au moins 1 voisin pas parcouru
            if (listeVoisins.size() > 0)
            {
                //ArrayList<int[]> list = listeVoisins;
                ArrayList<int[]> voisinsSansPhero = new ArrayList<>();

                //Retrait de la listeVoisins ceux n'ayant pas de phéromone
                for (int i=listeVoisins.size()-1; i>=0; i--)
                {
                    if (!this.getGraphe().contientPheromone(listeVoisins.get(i)[0], listeVoisins.get(i)[1]))
                    {
                        voisinsSansPhero.add(listeVoisins.get(i));
                        listeVoisins.remove(i);
                    }
                }

                //Tri de la liste selon quantité phéromone
                while (!isSorted(listeVoisins))
                {
                    for (int i=listeVoisins.size()-1; i>=1; i--)
                        if (this.getGraphe().getPheromoneAt(listeVoisins.get(i)[0], listeVoisins.get(i)[1]).getQuantity() < this.getGraphe().getPheromoneAt(listeVoisins.get(i-1)[0], listeVoisins.get(i-1)[1]).getQuantity())
                        {
                            listeVoisins.add(i-1, listeVoisins.get(i)); //Inversion avec celui d'avant
                            listeVoisins.remove(i+1); //Suppression de l'élément mal rangé
                        }
                }

                //On remet les voisins sans phéro en les insérant à l'indice 0
                for (int[] voisin : voisinsSansPhero)
                    listeVoisins.add(0, voisin);

                //Génération de la liste avec proba
                ArrayList<int[]> listeVoisinsAvecProba = new ArrayList<>();
                for (int i=0; i<listeVoisins.size(); i++)
                {
                    for (int j=0; j<i+1; j++) //Ou i+1 faut voir
                    {
                        listeVoisinsAvecProba.add(listeVoisins.get(i));
                    }
                }
                loc = listeVoisinsAvecProba.get(GameController.rdm.nextInt(listeVoisinsAvecProba.size()));
            }
            else if (listeVoisins.size() == 0) //Tous les voisins parcourus
            {
                listeVoisins = this.getListeVoisins();
                int index = GameController.rdm.nextInt(listeVoisins.size());
                this.deplacerVers(listeVoisins.get(index)[0], listeVoisins.get(index)[1]); //Déplacement random
            }
        }

        return loc;
    }

    private boolean isSorted(ArrayList<int[]> list)
    {
        boolean sorted = true;
        if (list.size() > 1)
            for (int i=list.size()-1; i>=1 && sorted; i--)
                if (this.getGraphe().getPheromoneAt(list.get(i)[0], list.get(i)[1]).getQuantity() < this.getGraphe().getPheromoneAt(list.get(i-1)[0], list.get(i-1)[1]).getQuantity()) //Mettre i-1
                    sorted = false;
        return sorted;
    }

    public ArrayList<int[]> getListeCasesParcourues()
    {
        return this.listeCasesParcourues;
    }

    public int getCarried()
    {
        return this.carried;
    }

    public void setCarried(int newQty)
    {
        this.carried = newQty;
    }
}
