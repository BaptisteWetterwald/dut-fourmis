package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GrapheTest
{

    Graphe g;
    Colony c;

    @BeforeEach
    void setUp()
    {
        g = new Graphe(10, 10);
        c = new Colony(5, 5, g, 1, 5);
        g.getTabGrid()[5][5].add(c);
    }

    @Test
    void getFourmiliere()
    {
        assertEquals(c, g.getFourmiliere());
    }

    @Test
    void deplacementValide()
    {
        g.getTabGrid()[1][1].add(new Obstacle(1, 1, g));

        assertTrue(g.deplacementValide(1, 2));
        assertFalse(g.deplacementValide(1, 1));
    }

    @Test
    void getListFourmis()
    {
        Queen q = g.getFourmiliere().getReine();

        for (int i=0; i<10; i++)
            q.donnerVie(Soldier.class);
        for (int i=0; i<10; i++)
            q.donnerVie(Worker.class);

        ArrayList<Ant> listAntsTab = new ArrayList<>();
        for (int i=0; i<g.getTabGrid().length; i++)
            for (int j=0; j<g.getTabGrid()[0].length; j++)
            {
                for (Occupant o : g.getTabGrid()[i][j])
                {
                    if (o instanceof Ant)
                        listAntsTab.add( (Ant) o);
                }
            }
        assertEquals(listAntsTab, g.getListFourmis());
    }

    @Test
    void getTabGrid()
    {
        //Simple accesseur pour récupérer la grille
    }

    @Test
    void contientFourmiliere()
    {
        g.getTabGrid()[4][4].add(new Colony(4, 4, g, 1, 5));
        assertTrue(g.contientFourmiliere(4, 4));
        assertFalse(g.contientFourmiliere(4, 5));
    }

    @Test
    void contientObstacle()
    {
        g.getTabGrid()[4][4].add(new Obstacle(4, 4, g));
        assertTrue(g.contientObstacle(4, 4));
        assertFalse(g.contientObstacle(4, 5));
    }

    @Test
    void contientSoldat()
    {
        g.getTabGrid()[4][4].add(new Soldier(4, 4, g, c));
        assertTrue(g.contientSoldat(4, 4));
        assertFalse(g.contientSoldat(4, 5));
    }

    @Test
    void contientPheromone()
    {
        g.getTabGrid()[4][4].add(new Pheromone(4, 4, g));
        assertTrue(g.contientPheromone(4, 4));
        assertFalse(g.contientPheromone(4, 5));
    }

    @Test
    void getPheromoneAt()
    {
        Pheromone p = new Pheromone(4, 4, g);
        g.getTabGrid()[4][4].add(p);

        assertNull(g.getPheromoneAt(4, 5));
        assertEquals(p, g.getPheromoneAt(4, 4));
    }

    @Test
    void getFoodAt()
    {
        Food f = new Food(4, 4, g);
        g.getTabGrid()[4][4].add(f);

        assertNull(g.getFoodAt(4, 5));
        assertEquals(f, g.getFoodAt(4, 4));
    }

    @Test
    void contientOuvriereVide()
    {
        Worker w1 = new Worker(4, 4, g, c);
        g.getTabGrid()[4][4].add(w1);

        assertTrue(g.contientOuvriereVide(4, 4));

        w1.setCarried(1);
        assertFalse(g.contientOuvriereVide(4, 4));
    }

    @Test
    void contientOuvrierePorteuse()
    {
        Worker w1 = new Worker(4, 4, g, c);
        g.getTabGrid()[4][4].add(w1);

        assertFalse(g.contientOuvrierePorteuse(4, 4));

        w1.setCarried(1);
        assertTrue(g.contientOuvrierePorteuse(4, 4));
    }

    @Test
    void contientNourriture()
    {
        g.getTabGrid()[4][4].add(new Food(4, 4, g));
        assertTrue(g.contientNourriture(4, 4));
        assertFalse(g.contientNourriture(4, 5));
    }

    @Test
    void putFood()
    {
        assertFalse(g.contientNourriture(4, 4));
        g.putFood(4, 4, 10);
        assertTrue(g.contientNourriture(4, 4));
        assertEquals(10, g.getFoodAt(4, 4).getQuantity());
    }

    @Test
    void getListPheromones()
    {
        Worker w = new Worker(4, 4, g, c);
        g.getTabGrid()[4][4].add(w);
        w.depositPheromone();
        w.deplacerVers(4, 5);
        w.depositPheromone();
        w.deplacerVers(4, 6);
        w.depositPheromone();

        ArrayList<Pheromone> listPheroTab = new ArrayList<>();
        for (int i=0; i<g.getTabGrid().length; i++)
            for (int j=0; j<g.getTabGrid()[0].length; j++)
            {
                for (Occupant o : g.getTabGrid()[i][j])
                {
                    if (o instanceof Pheromone)
                        listPheroTab.add( (Pheromone) o);
                }
            }
        assertEquals(listPheroTab, g.getListPheromones());
    }

    @Test
    void fill()
    {
        for (int i=0; i<g.getTabGrid().length; i++)
            for (int j=0; j<g.getTabGrid()[0].length; j++)
                assertNotNull(g.getTabGrid()[i][j]);
    }
}