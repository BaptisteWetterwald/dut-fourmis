package v2;

import java.util.BitSet;

public class GameController implements AntFacadeController
{
    Grid grid;

    @Override
    public void setParameters(int evaporationParam, int foodParam, int pheromoneParam)
    {

    }

    @Override
    public void createGrid(int width, int height)
    {
        grid = new Grid(width, height);
    }

    @Override
    public void putObstacle(int row, int column)
    {
        if (!grid.contientFourmiliere(row, column))
            grid.getTabGrid()[row][column].add(new Obstacle(row, column, grid));
        else
            throw new IllegalArgumentException("Impossible de placer un obstacle sur une fourmilière.");
    }

    @Override
    public void putFood(int row, int column, int quantity) {

    }

    @Override
    public void createColony(int row, int column)
    {
        grid.getTabGrid()[row][column].add(new Colony(row, column, grid));
    }

    @Override
    public void createSoldiers(int amount)
    {
        for (int i=0; i<amount; i++)
            grid.getFourmiliere().getReine().donnerVie();
    }

    @Override
    public void createWorkers(int amount) {

    }

    @Override
    public void setAntFile(String antLogFile) {

    }

    @Override
    public BitSet[][] play(int duration, boolean record)
    {
        BitSet[][] bs = new BitSet[grid.getTabGrid().length][grid.getTabGrid()[0].length];
        refreshBitSet(bs);

        for (int i=0; i<duration; i++)
        {
            for (Ant f : grid.getListFourmis())
                if (f instanceof Soldier)
                    ((Soldier) f).deplacementHasard(grid);
        }
        refreshBitSet(bs);

        return bs;
    }

    private void refreshBitSet(BitSet[][] bs)
    {
        for (int i=0; i<grid.getTabGrid().length; i++)
            for (int j=0; j<grid.getTabGrid()[0].length; j++)
            {
                bs[i][j] = new BitSet(7);
                if (grid.contientFourmiliere(i, j))
                    bs[i][j].set(0, true);
                if (grid.contientObstacle(i, j))
                    bs[i][j].set(1, true);
                if (grid.contientSoldat(i, j))
                    bs[i][j].set(2, true);
            }
    }

}
