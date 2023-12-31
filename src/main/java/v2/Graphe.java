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
     * Définit la validité d'un déplacement selon son occupation par un obstacle
     *
     * @param x ligne de la nouvelle position à tester
     * @param y colonne de la nouvelle position à tester
     * @return true si le déplacement est valide, false sinon
     */
    public boolean deplacementValide(int x, int y)
    {
        boolean valide = true;

        //Si la case n'est pas dans la grille
        if (x<0 || x>=this.getTabGrid().length || y<0 || y>=this.getTabGrid()[0].length)
            valide = false;

            //Si la case contient un obstacle
        else
            for (int i = 0; i<this.getTabGrid()[x][y].size() && valide; i++)
                if (this.getTabGrid()[x][y].get(i) instanceof Obstacle)
                    valide = false;
        return valide;
    }

    /**
     * Retourne la colonie associée au graphe (en partant du principe qu'il n'y en a qu'une pour le moment)
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
     * Simple accesseur
     * Retourne la liste des fourmis présentes sur le graphe
     *
     * @return liste des fourmis du graphe
     */
    public ArrayList<Ant> getListFourmis()
    {
        return this.listAnts;
    }

    /**
     * Simple accesseur
     * Retourne la grille sur laquelle se déplacent les fourmis
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
     * @param x ligne de la position à tester sur le tableau
     * @param y colonne de la position à tester sur le tableau
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
     * @param x ligne de la position à tester sur le tableau
     * @param y colonne de la position à tester sur le tableau
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
     * @param x ligne de la position à tester sur le tableau
     * @param y colonne de la position à tester sur le tableau
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

    /**
     * Détermine si une position de la grille contient une instance de Pheromone
     *
     * @param x ligne de la position à tester sur le tableau
     * @param y colonne de la position à tester sur le tableau
     * @return true si la position contient une instance de Pheromone, false sinon
     */
    public boolean contientPheromone(int x, int y)
    {
        boolean contains = true;
        if (this.getPheromoneAt(x, y) == null)
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


    /**
     * Retourne la pheromone présente à la position précisée
     *
     * @param x ligne de la position
     * @param y colonne de la position
     * @return l'instance de Pheromone présente à la position, null s'il n'y en a pas
     */
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

    /**
     * Retourne la nourriture présente à la position précisée
     *
     * @param x ligne de la position
     * @param y colonne de la position
     * @return l'instance de Food présente à la position, null s'il n'y en a pas
     */
    public Food getFoodAt(int x, int y)
    {
        Food food = null;
        ArrayList<Occupant> occupants = this.tabGrid[x][y];
        for (int i=0; i<occupants.size() && food==null; i++)
            if (occupants.get(i) instanceof Food)
                food = (Food) occupants.get(i);
        return food;
    }

    /**
     * Détermine si une position de la grille contient une fourmi-ouvrière ne portant pas de nourriture
     *
     * @param x ligne de la position à tester sur le tableau
     * @param y colonne de la position à tester sur le tableau
     * @return true si elle en contient une, false sinon
     */
    public boolean contientOuvriereVide(int x, int y)
    {
        boolean contains = false;
        for (int i = 0; i<this.tabGrid[x][y].size() && !contains; i++)
            if (this.tabGrid[x][y].get(i) instanceof Worker)
                if (( (Worker)this.tabGrid[x][y].get(i) ).getCarried() == 0)
                    contains = true;
        return contains;
    }

    /**
     * Détermine si une position de la grille contient une fourmi-ouvrière portant de la nourriture
     *
     * @param x ligne de la position à tester sur le tableau
     * @param y colonne de la position à tester sur le tableau
     * @return true si elle en contient une, false sinon
     */
    public boolean contientOuvrierePorteuse(int x, int y)
    {
        boolean contains = false;
        for (int i = 0; i<this.tabGrid[x][y].size() && !contains; i++)
            if (this.tabGrid[x][y].get(i) instanceof Worker)
                if (( (Worker)this.tabGrid[x][y].get(i) ).getCarried() > 0)
                    contains = true;
        return contains;
    }

    /**
     * Détermine si une position de la grille contient une instance de Food
     *
     * @param x ligne de la position à tester sur le tableau
     * @param y colonne de la position à tester sur le tableau
     * @return true si elle en contient une, false sinon
     */
    public boolean contientNourriture(int x, int y)
    {
        return (this.getFoodAt(x, y) != null);
    }


    /**
     * Ajoute la quantité précisée à la quantité de nourriture présente à la position précisée
     *
     * @param x ligne de la position
     * @param y colonne de la position
     * @param quantity quantité à ajouter
     */
    public void putFood(int x, int y, int quantity)
    {
        Food food = null;
        if (!this.contientNourriture(x, y))
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

    /**
     * Simple accesseur
     * Retourne la liste des phéromones présentes sur le graphe
     *
     * @return liste des pheromones du graphe
     */
    public ArrayList<Pheromone> getListPheromones()
    {
        return this.listPheromones;
    }
}
