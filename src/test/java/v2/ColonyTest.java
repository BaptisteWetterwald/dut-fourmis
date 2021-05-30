package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColonyTest
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
    void getReine()
    {
        assertEquals(g.getTabGrid()[5][5].get(0), c.getReine());
    }

    @Test
    void getFoodWithdrawal()
    {
        assertEquals(5, c.getFoodWithdrawal());
    }

    @Test
    void getPheromoneDeposit()
    {
        assertEquals(1, c.getPheromoneDeposit());
    }
}