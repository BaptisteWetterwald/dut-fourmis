package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {
    Graphe g;
    Colony c;
    Queen q;

    @BeforeEach
    void setUp() {
        g= new Graphe( 10,20);
        c= new Colony(2,7,g,7,3);
        q = new Queen(2,7,g,c);
    }

    @Test
    void donnerVie() {

        g.getTabGrid()[4][4].add(q);
        int sizeBefore = g.getListFourmis().size();
        for (int i=0; i<10; i++)
            q.donnerVie(c);
        assertEquals(sizeBefore + 10, g.getListFourmis().size());
    }
}