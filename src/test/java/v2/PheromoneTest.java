package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PheromoneTest
{
    Graphe g;
    Colony c;
    Worker w;

    @BeforeEach
    void setUp()
    {
        g = new Graphe(10, 10);
        c = new Colony(5, 5, g, 3, 5);
        g.getTabGrid()[5][5].add(c);
        w = new Worker(4, 4, g, c);
        g.getTabGrid()[4][4].add(w);
    }

    @Test
    void getQuantity()
    {
        for (int i=0; i<4; i++)
        {
            w.depositPheromone();
        }
        assertEquals(4*c.getPheromoneDeposit(), g.getPheromoneAt(4, 4).getQuantity());
    }

    @Test
    void setQuantity()
    {
        w.depositPheromone();
        Pheromone p = g.getPheromoneAt(4, 4);
        p.setQuantity(10);
        assertEquals(10, p.getQuantity());
    }

    @Test
    void evaporate()
    {
        Pheromone p = new Pheromone(5, 5, g);
        p.setQuantity(15);
        p.evaporate(5);
        assertEquals(10, p.getQuantity());
    }
}