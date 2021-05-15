package v1;

import java.util.ArrayList;
import java.util.Random;

public class Grid
{
    Random rdm = new Random();

    private ArrayList<Occupant>[][] tabGrid;
    //private ArrayList<Obstacle> listObstacles;
    private ArrayList<Ant> listAnts;

    public Grid(int width, int height)
    {
        this.tabGrid = new ArrayList[height][width];
        this.fill();
        //this.listObstacles = new ArrayList<Obstacle>();
        this.listAnts = new ArrayList<Ant>();
        //this.putFourmiliere(this.tabGrid);
        //this.putObstacles(this.tabGrid, 5);
        //this.putFourmis(this.getFourmiliere().getReine(), 10);
    }

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

    private void putFourmiliere(ArrayList<Occupant>[][] grid)
    {
        int rdmX = rdm.nextInt(grid.length);
        int rdmY = rdm.nextInt(grid[0].length);
        this.tabGrid[rdmX][rdmY].add(new Colony(rdmX, rdmY, this));
    }

    public ArrayList<Ant> getListFourmis()
    {
        return this.listAnts;
    }

    private void putFourmis(Queen queen, int nbFourmis)
    {
        /*int fourmisPlacees = 0;
        while (fourmisPlacees < nbFourmis)
        {
            int rdmX = rdm.nextInt(grid.length);
            int rdmY = rdm.nextInt(grid[0].length);
            if (!this.contientObstacle(rdmX, rdmY))
            {
                Fourmi fourmi = new Soldat(rdmX, rdmY);
                this.tabGrid[rdmX][rdmY].add(fourmi);
                listFourmis.add(fourmi);
                fourmisPlacees++;
            }
        }*/
        for (int i=0; i<nbFourmis; i++)
            queen.donnerVie();
    }

    public ArrayList<Occupant>[][] getTabGrid()
    {
        return this.tabGrid;
    }

    private void putObstacles(ArrayList<Occupant>[][] grid, int nbObstacles)
    {
        int obstaclesPlaces = 0;
        while (obstaclesPlaces < nbObstacles)
        {
            int rdmX = rdm.nextInt(grid.length);
            int rdmY = rdm.nextInt(grid[0].length);
            if ( !this.contientObstacle(rdmX, rdmY) && !this.contientFourmiliere(rdmX, rdmY))
            {
                Obstacle obstacle = new Obstacle(rdmX, rdmY, this);
                this.tabGrid[rdmX][rdmY].add(obstacle);
                //this.listObstacles.add(obstacle);
                obstaclesPlaces++;
            }
        }
    }

    public boolean contientFourmiliere(int x, int y)
    {
        boolean contains = false;
        for (int i=0; i<this.tabGrid[x][y].size() && !contains; i++)
            if (this.tabGrid[x][y].get(i) instanceof Colony)
                contains = true;
        return contains;
    }

    public boolean contientObstacle(int x, int y)
    {
        boolean contains = false;
        for (int i = 0; i<this.tabGrid[x][y].size() && !contains; i++)
            if (this.tabGrid[x][y].get(i) instanceof Obstacle)
                contains = true;
        return contains;
    }

    public boolean contientSoldat(int x, int y)
    {
        boolean contains = false;
        for (int i = 0; i<this.tabGrid[x][y].size() && !contains; i++)
            if (this.tabGrid[x][y].get(i) instanceof Soldier)
                contains = true;
        return contains;
    }

    public void showGrid()
    {
        for (int i = 0; i< tabGrid.length; i++)
        {
            for (int j = 0; j< tabGrid[0].length; j++)
            {
                System.out.print("  ");
                if (this.tabGrid[i][j].size()==0)
                    System.out.print(".");
                else
                    System.out.print(stringList(this.tabGrid[i][j]));
            }
            System.out.println();
        }
    }

    private String stringList(ArrayList<Occupant> occupants)
    {
        String s = "";
        for (Occupant occ : occupants)
        {
            s += occ.toString();
        }
        return s;
    }

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

    /*public ArrayList<Obstacle> getListObstacles()
    {
        return this.listObstacles;
    }*/

    /*public void showListObstacles()
    {
        for (Obstacle ob : listObstacles)
        {
            System.out.println("X=" + ob.getX());
            System.out.println("Y=" + ob.getY());
            System.out.println();
        }
    }*/
}
