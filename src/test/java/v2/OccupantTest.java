package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OccupantTest
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
    void getGraphe()
    {
        Soldier s = new Soldier(4, 4, g, c);

        assertEquals(g, s.getGraphe());
    }

    @Test
    void getX()
    {
        Soldier s = new Soldier(4, 5, g, c);
        assertEquals(4, s.getX());
    }

    @Test
    void getY()
    {
        Soldier s = new Soldier(4, 5, g, c);
        assertEquals(5, s.getY());
    }

    @Test
    void setX()
    {
        Soldier s = new Soldier(4, 4, g, c);
        s.setX(5);
        assertEquals(5, s.getX());
    }

    @Test
    void setY()
    {
        Soldier s = new Soldier(4, 4, g, c);
        s.setY(5);
        assertEquals(5, s.getY());
    }
}