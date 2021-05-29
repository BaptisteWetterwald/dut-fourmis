package v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AntTest {
    Graphe g;
    Ant a;
    Queen q;

    @BeforeEach
    void setUp() {
        g = new Graphe(10, 15);
        q= new Queen(4,7,g);
        a = new Ant(2,5,g);
    }

    @Test
    void deplacerVers() {
        a.deplacerVers(7, 13);
        assertEquals(7, a.getX());
        assertEquals(13, a.getY());
    }

    boolean b;
    @Test
    void deplacementValide() {
        //----------------------------------------------------------------------------------------------------------
    }
}
