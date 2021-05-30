package v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GrapheTest
{
    Graphe g;

    @BeforeEach
    void setUp()
    {
        g = new Graphe(10, 23);
    }

    @Test
    void getFourmiliere()
    {
        g.getTabGrid()[4][7].add(new Colony(4, 7, g));
        assertEquals(g.getFourmiliere(), g.getTabGrid()[4][7].get(1)); // Car la Reine occupe l'index 0
    }

    @Test
    void getListFourmis()
    {
        Queen q = new Queen(4, 4, g);
        for (int i=0; i<10; i++)
            q.donnerVie();
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
    void contientFourmiliere()
    {
        g.getTabGrid()[4][4].add(new Colony(4, 4, g));
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
        g.getTabGrid()[4][4].add(new Soldier(4, 4, g));
        assertTrue(g.contientSoldat(4, 4));
        assertFalse(g.contientSoldat(4, 5));
    }


    @Test
    void fill()
    {
        for (int i=0; i<g.getTabGrid().length; i++)
            for (int j=0; j<g.getTabGrid()[0].length; j++)
                assertNotNull(g.getTabGrid()[i][j]);
    }

}