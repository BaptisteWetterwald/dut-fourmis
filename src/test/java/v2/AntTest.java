package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import v1.Ant;
import v1.Graphe;

import static org.junit.jupiter.api.Assertions.*;

class AntTest {

    v2.Graphe g;
    v2.Ant a;
    v2.Queen q;
    Colony c;
    @BeforeEach
    void setUp() {
        g = new v2.Graphe(10, 15);
        c = new Colony(7,6,g,3,8);
        q= new Queen(4,7,g,c);
        a = new v2.Ant(3,6,g,c);
    }

    @Test
    void seDeplacer() {

    }

    @Test
    void deplacerVers() {
        a.deplacerVers(7, 13);
        assertEquals(7, a.getX());
        assertEquals(13, a.getY());
    }

    @Test
    void deplacementValide() {
        //------------------------------------------------------------------------

    }

    @Test
    void getColony() {
        assertEquals(c,a.getColony());
    }

    @Test
    void getListeVoisins() {
        //------------------------------------------------------------------------
    }
}