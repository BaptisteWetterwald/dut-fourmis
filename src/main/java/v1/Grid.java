package v1;

import java.util.ArrayList;
import java.util.Random;

public class Grid
{
    Random rdm = new Random();

    private ArrayList<Occupant>[][] grid;
    private ArrayList<Obstacle> listObstacles;
    private ArrayList<Fourmi> listFourmis;

    public Grid(int width, int height)
    {
        this.grid = new ArrayList[height][width];
        this.fill();
        this.listObstacles = new ArrayList<Obstacle>();
        this.listFourmis = new ArrayList<Fourmi>();
        this.putObstacles(this.grid, 5);
        this.putFourmis(this.grid, 10);
    }

    public ArrayList<Fourmi> getListFourmis()
    {
        return this.listFourmis;
    }

    private void putFourmis(ArrayList<Occupant>[][] grid, int nbFourmis)
    {
        int fourmisPlacees = 0;
        while (fourmisPlacees < nbFourmis)
        {
            int rdmX = rdm.nextInt(grid.length);
            int rdmY = rdm.nextInt(grid[0].length);
            if (!this.contientObstacle(rdmX, rdmY))
            {
                Fourmi fourmi = new Fourmi(rdmX, rdmY);
                this.grid[rdmX][rdmY].add(fourmi);
                listFourmis.add(fourmi);
                fourmisPlacees++;
            }
        }
    }

    public ArrayList<Occupant>[][] getGrid()
    {
        return this.grid;
    }

    private void putObstacles(ArrayList<Occupant>[][] grid, int nbObstacles)
    {
        int obstaclesPlaces = 0;
        while (obstaclesPlaces < nbObstacles)
        {
            int rdmX = rdm.nextInt(grid.length);
            int rdmY = rdm.nextInt(grid[0].length);
            if ( !this.contientObstacle(rdmX, rdmY) )
            {
                Obstacle obstacle = new Obstacle(rdmX, rdmY);
                this.grid[rdmX][rdmY].add(obstacle);
                this.listObstacles.add(obstacle);
                obstaclesPlaces++;
            }
        }
    }

    private boolean contientObstacle(int x, int y)
    {
        boolean contains = false;
        for (int i=0; i<this.grid[x][y].size() && !contains; i++)
            if (this.grid[x][y].get(i) instanceof Obstacle)
                contains = true;
        return contains;
    }

    public void showGrid()
    {
        for (int i=0; i<grid.length; i++)
        {
            for (int j=0; j<grid[0].length; j++)
            {
                System.out.print("  ");
                if (this.grid[i][j].size()==0)
                    System.out.print(".");
                else
                    System.out.print(stringList(this.grid[i][j]));
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
        for (int i=0; i<grid.length; i++)
        {
            for (int j=0; j<grid[0].length; j++)
            {
                grid[i][j] = new ArrayList<Occupant>();
            }
        }
    }

    public ArrayList<Obstacle> getListObstacles()
    {
        return this.listObstacles;
    }

    public void showListObstacles()
    {
        for (Obstacle ob : listObstacles)
        {
            System.out.println("X=" + ob.getX());
            System.out.println("Y=" + ob.getY());
            System.out.println();
        }
    }
}
