package v2;

import java.util.ArrayList;

public class Graphe
{
    private final ArrayList<Occupant>[][] tabGrid;
    private final ArrayList<Ant> listAnts;
    private final ArrayList<Pheromone> listPheromones;

    /**
     * Constructeur classe Graphe
     *
     * @param width largeur du tableau
     * @param height hauteur du tableau
     */
    public Graphe(int height, int width)
    {
        this.tabGrid = new ArrayList[height][width];
        this.fill();
        this.listAnts = new ArrayList<>();
        this.listPheromones = new ArrayList<>();
    }

    /**
     * Retourne la colonie associée au graphe
     *
     * @return colonie associée au graphe
     */
    public Colony getFourmiliere()
    {
        Colony colony = null;
        boolean found = false;
        for (int i=0; i<this.tabGrid.length && !found; i++)
            for (int j=0; j<this.tabGrid[0].length && !found; j++)
            {
                for (Occupant occ : this.tabGrid[i][j])
                    if (occ instanceof Colony)
                    {
                        found = true;
                        colony = (Colony) occ;
                    }
            }
        return colony;
    }

    /**
     * Retourne la liste des fourmis dans le graphe
     *
     * @return liste des fourmis du graphe
     */
    public ArrayList<Ant> getListFourmis()
    {
        return this.listAnts;
    }

    /**
     * Retourne la grille sur laquette se déplacent les fourmis
     *
     * @return tableau de listes d'occupants, sur lequel se déplacent les fourmis
     */
    public ArrayList<Occupant>[][] getTabGrid()
    {
        return this.tabGrid;
    }

    /**
     * Détermine si une position de la grille contient une colonie
     *
     * @param x abscisse de la position à tester sur le tableau
     * @param y ordonnée de la position à tester sur le tableau
     * @return true si la position contient une colonie, false sinon
     */
    public boolean contientFourmiliere(int x, int y)
    {
        boolean contains = false;
        for (int i=0; i<this.tabGrid[x][y].size() && !contains; i++)
            if (this.tabGrid[x][y].get(i) instanceof Colony)
                contains = true;
        return contains;
    }

    /**
     * Détermine si une position de la grille contient un obstacle
     *
     * @param x abscisse de la position à tester sur le tableau
     * @param y ordonnée de la position à tester sur le tableau
     * @return true si la position contient un obstacle, false sinon
     */
    public boolean contientObstacle(int x, int y)
    {
        boolean contains = false;
        for (int i = 0; i<this.tabGrid[x][y].size() && !contains; i++)
            if (this.tabGrid[x][y].get(i) instanceof Obstacle)
                contains = true;
        return contains;
    }

    /**
     * Détermine si une position de la grille contient une fourmi-soldat
     *
     * @param x abscisse de la position à tester sur le tableau
     * @param y ordonnée de la position à tester sur le tableau
     * @return true si la position contient une fourmi-soldat, false sinon
     */
    public boolean contientSoldat(int x, int y)
    {
        boolean contains = false;
        for (int i = 0; i<this.tabGrid[x][y].size() && !contains; i++)
            if (this.tabGrid[x][y].get(i) instanceof Soldier)
                contains = true;
        return contains;
    }

    public boolean contientPheromone(int x, int y)
    {
        boolean contains = true;
        if (getPheromoneAt(x, y) == null)
            contains = false;
        return contains;
    }

    /**
     *  Remplit le tableau de la grille avec des listes vides d'occupants
     */
    private void fill()
    {
        for (int i = 0; i< tabGrid.length; i++)
        {
            for (int j = 0; j< tabGrid[0].length; j++)
            {
                tabGrid[i][j] = new ArrayList<Occupant>();
            }
        }
    }

    public Pheromone getPheromoneAt(int x, int y)
    {
        Pheromone phero = null;
        boolean found = false;
        ArrayList<Occupant> occupants = this.tabGrid[x][y];
        for (int i=0; i<occupants.size() && !found; i++)
        {
            if (occupants.get(i) instanceof Pheromone)
            {
                found = true;
                phero = (Pheromone) occupants.get(i);
            }
        }
        return phero;
    }

    public Food getFoodAt(int x, int y)
    {
        Food food = null;
        ArrayList<Occupant> occupants = this.tabGrid[x][y];
        for (int i=0; i<occupants.size() && food==null; i++)
            if (occupants.get(i) instanceof Food)
                food = (Food) occupants.get(i);
        return food;
    }

    public boolean contientOuvriereVide(int x, int y)
    {
        boolean contains = false;
        for (int i = 0; i<this.tabGrid[x][y].size() && !contains; i++)
            if (this.tabGrid[x][y].get(i) instanceof Worker)
                if (( (Worker)this.tabGrid[x][y].get(i) ).getCarried() == 0)
                    contains = true;
        return contains;
    }

    public boolean contientOuvrierePorteuse(int x, int y)
    {
        boolean contains = false;
        for (int i = 0; i<this.tabGrid[x][y].size() && !contains; i++)
            if (this.tabGrid[x][y].get(i) instanceof Worker)
                if (( (Worker)this.tabGrid[x][y].get(i) ).getCarried() > 0)
                    contains = true;
        return contains;
    }

    public boolean contientNourriture(int x, int y)
    {
        return (this.getFoodAt(x, y) != null);
    }

    public void putFood(int x, int y, int quantity)
    {
        Food food = null;
        if (!contientNourriture(x, y))
        {
            food = new Food(x, y, this);
            this.tabGrid[x][y].add(food);
        }
        else
        {
            for (int i = 0; i<this.tabGrid[x][y].size() && food==null; i++)
                if (this.tabGrid[x][y].get(i) instanceof Food)
                    food = (Food)this.tabGrid[x][y].get(i);
        }
        assert food != null;
        food.setQuantity(food.getQuantity() + quantity);
    }

    public ArrayList<Pheromone> getListPheromones()
    {
        return this.listPheromones;
    }
}
