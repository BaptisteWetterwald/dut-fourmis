package v2;

import java.util.BitSet;

public class GameController implements AntFacadeController
{
    private Graphe graphe;
    private int evaporationParam;
    private int foodParam;
    private int pheromoneParam;

    @Override
    public void setParameters(int evaporationParam, int foodParam, int pheromoneParam)
    {
        this.evaporationParam = evaporationParam;
        this.foodParam = foodParam;
        this.pheromoneParam = pheromoneParam;
    }

    @Override
    public void createGrid(int width, int height)
    {
        graphe = new Graphe(height, width);
    }

    @Override
    public void putObstacle(int row, int column)
    {
        if (!graphe.contientFourmiliere(row, column))
            graphe.getTabGrid()[row][column].add(new Obstacle(row, column, graphe));
        else
            throw new IllegalArgumentException("Impossible de placer un obstacle sur une fourmilière.");
    }

    @Override
    public void putFood(int row, int column, int quantity)
    {

    }

    @Override
    public void createColony(int row, int column)
    {
        graphe.getTabGrid()[row][column].add(new Colony(row, column, graphe, 5, 5));
    }

    @Override
    public void createSoldiers(int amount)
    {
        for (int i=0; i<amount; i++)
            graphe.getFourmiliere().getReine().donnerVie(Soldier.class);
    }

    @Override
    public void createWorkers(int amount)
    {
        for (int i=0; i<amount; i++)
            graphe.getFourmiliere().getReine().donnerVie(Worker.class);
    }

    @Override
    public void setAntFile(String antLogFile)
    {

    }

    @Override
    public BitSet[][] play(int duration, boolean record)
    {
        BitSet[][] bs = new BitSet[graphe.getTabGrid().length][graphe.getTabGrid()[0].length];
        refreshBitSet(bs, graphe);

        for (int i=0; i<duration; i++)
        {
            for (Ant f : graphe.getListFourmis())
                f.seDeplacer();
        }
        refreshBitSet(bs, graphe);

        return bs;
    }

    /**
     * @param bs BitSet à actualiser
     * @param graphe Graphe utilisé pour l'actualisation
     */
    private void refreshBitSet(BitSet[][] bs, Graphe graphe)
    {
        for (int i = 0; i< graphe.getTabGrid().length; i++)
            for (int j = 0; j< graphe.getTabGrid()[0].length; j++)
            {
                bs[i][j] = new BitSet(7);
                if (graphe.contientFourmiliere(i, j))
                    bs[i][j].set(0, true);
                if (graphe.contientObstacle(i, j))
                    bs[i][j].set(1, true);
                if (graphe.contientSoldat(i, j))
                    bs[i][j].set(2, true);
            }
    }

}
