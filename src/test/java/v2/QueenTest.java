package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest
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
    void donnerVie()
    {
        int sizeBefore = g.getListFourmis().size();
        for (int i=0; i<5; i++)
            c.getReine().donnerVie(Worker.class);
        for (int i=0; i<5; i++)
            c.getReine().donnerVie(Soldier.class);
        assertEquals(sizeBefore + 10, g.getListFourmis().size());
    }
}