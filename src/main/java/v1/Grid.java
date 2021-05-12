package v1;

import java.util.ArrayList;
import java.util.Random;

public class Grid
{
    Random rdm = new Random();

    private Occupant[][] grid;
    private ArrayList<Obstacle> listObstacles;

    public Grid(int width, int height)
    {
        this.grid = new Occupant[width][height];
        this.listObstacles = new ArrayList<Obstacle>();
        this.putObstacles(this.grid, 5);
        this.putFourmis(this.grid, 10);
        this.fill();
    }

    private void putFourmis(Occupant[][] grid, int nbFourmis)
    {
        for (int i=0; i<nbFourmis; i++)
        {
            int rdmX = rdm.nextInt(grid.length);
            int rdmY = rdm.nextInt(grid[0].length);
            if ( !this.contientObstacle(rdmX, rdmY) && grid[rdmX][rdmY]==null )
            {
                Occupant fourmi = new Fourmi(rdmX, rdmY);
                this.grid[rdmX][rdmY] = fourmi;
            }
        }
    }

    public Occupant[][] getGrid()
    {
        return this.grid;
    }

    private void putObstacles(Occupant[][] grid, int nbOstacles)
    {
        for (int i=0; i<nbOstacles; i++)
        {
            int rdmX = rdm.nextInt(grid.length);
            int rdmY = rdm.nextInt(grid[0].length);
            if ( !this.contientObstacle(rdmX, rdmY) )
            {
                Obstacle obstacle = new Obstacle(rdmX, rdmY);
                this.grid[rdmX][rdmY] = obstacle;
                this.listObstacles.add(obstacle);
            }
        }
    }

    private boolean contientObstacle(int x, int y)
    {
        if (this.grid[x][y] instanceof Obstacle)
            return true;
        return false;
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
                if (grid[i][j] == null)
                    grid[i][j] = new Occupant(i, j);
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
