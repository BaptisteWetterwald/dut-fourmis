package v1;

public class Main
{
    public static void main(String[] args)
    {
        Grid grid = new Grid(10, 10);
        grid.showGrid();
        //grid.showListObstacles();
        int nbIterations = 200;
        for (int i=0; i<nbIterations; i++)
        {
            System.out.println();
            System.out.println();
            for (Fourmi f : grid.getListFourmis())
                ((Soldat)f).deplacementHasard(grid);
            grid.showGrid();
        }

    }
}
