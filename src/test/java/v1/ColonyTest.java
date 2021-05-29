package v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColonyTest {
    Graphe g;
    Colony a;
    Queen q;
    @BeforeEach
    void setUp() {
        g= new Graphe(5,10);
        q = new Queen(4,5,g);

    }

    @Test
    void getReine() {
        assertEquals(4, q.getX());
        assertEquals(5, q.getY());
        assertEquals(g,q.getGraphe());
    }
}