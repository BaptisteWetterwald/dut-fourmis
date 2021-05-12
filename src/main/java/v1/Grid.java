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
        this.grid = new ArrayList<Occupant>[][];
        this.listObstacles = new ArrayList<Obstacle>();
        this.listFourmis = new ArrayList<Fourmi>();
        this.putObstacles(this.grid, 5);
        this.putFourmis(this.grid, 10);
        this.fill();
    }

    public ArrayList<Fourmi> getListFourmis()
    {
        return this.listFourmis;
    }

    private void putFourmis(ArrayList<Occupant>[][] grid, int nbFourmis)
    {
        for (int i=0; i<nbFourmis; i++)
        {
            int rdmX = rdm.nextInt(grid.length);
            int rdmY = rdm.nextInt(grid[0].length);
            if ( !this.contientObstacle(rdmX, rdmY) && grid[rdmX][rdmY]==null )
            {
                Fourmi fourmi = new Fourmi(rdmX, rdmY);
                this.grid[rdmX][rdmY].add(fourmi);
                listFourmis.add(fourmi);
            }
        }
    }

    public ArrayList<Occupant>[][] getGrid()
    {
        return this.grid;
    }

    private void putObstacles(ArrayList<Occupant>[][] grid, int nbOstacles)
    {
        for (int i=0; i<nbOstacles; i++)
        {
            int rdmX = rdm.nextInt(grid.length);
            int rdmY = rdm.nextInt(grid[0].length);
            if ( !this.contientObstacle(rdmX, rdmY) )
            {
                Obstacle obstacle = new Obstacle(rdmX, rdmY);
                this.grid[rdmX][rdmY].add(obstacle);
                this.listObstacles.add(obstacle);
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
                System.out.print("  " + this.grid[i][j].toString());
            }
            System.out.println();
        }
    }

    private void fill()
    {
        for (int i=0; i<grid.length; i++)
        {
            for (int j=0; j<grid[0].length; j++)
            {
                if (grid[i][j].size() == 0)
                    grid[i][j].add(new Occupant(i, j));
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
