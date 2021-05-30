package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest
{

    Graphe g;
    Colony c;
    Queen q;

    @BeforeEach
    void setUp()
    {
        g = new Graphe(10, 10);
        c = new Colony(5, 5, g, 1, 5);
        g.getTabGrid()[5][5].add(c);
        q = new Queen(4, 4, g, c);
        g.getTabGrid()[4][4].add(q);
    }

    @Test
    void donnerVie()
    {
        int sizeBefore = g.getListFourmis().size();
        for (int i=0; i<5; i++)
            q.donnerVie(Worker.class);
        for (int i=0; i<5; i++)
            q.donnerVie(Soldier.class);
        assertEquals(sizeBefore + 10, g.getListFourmis().size());
    }
}