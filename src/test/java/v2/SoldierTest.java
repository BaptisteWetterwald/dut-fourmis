package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest
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
    void deplacementHasard()
    {

        int x = GameController.rdm.nextInt(10);
        int y = GameController.rdm.nextInt(10);

        Soldier s = new Soldier(x, y, g, c);
        g.getTabGrid()[x][y].add(s);
        s.deplacementHasard();
        assertTrue(
                (s.getX()==x && s.getY()==y-1) ||
                        (s.getX()==x && s.getY()==y+1) ||
                        (s.getX()==x-1 && s.getY()==y) ||
                        (s.getX()==x+1 && s.getY()==y)
        );
    }

    @Test
    void seDeplacer()
    {
        int x = GameController.rdm.nextInt(10);
        int y = GameController.rdm.nextInt(10);

        Soldier s = new Soldier(x, y, g, c);
        g.getTabGrid()[x][y].add(s);
        s.seDeplacer();
        assertTrue(
                (s.getX()==x && s.getY()==y-1) ||
                        (s.getX()==x && s.getY()==y+1) ||
                        (s.getX()==x-1 && s.getY()==y) ||
                        (s.getX()==x+1 && s.getY()==y)
        );
    }
}