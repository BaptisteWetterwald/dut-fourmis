package v1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest
{
    Graphe g;

    @BeforeEach
    void setUp()
    {
        g = new Graphe(10, 23);
    }

    @Test
    void donnerVie()
    {
        Queen q = new Queen(4, 4, g);
        g.getTabGrid()[4][4].add(q);
        int sizeBefore = g.getListFourmis().size();
        for (int i=0; i<10; i++)
            q.donnerVie();
        assertEquals(sizeBefore + 10, g.getListFourmis().size());
    }
}