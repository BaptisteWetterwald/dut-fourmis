package v1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest
{
    Graphe g;

    @BeforeEach
    void setUp()
    {
        g = new Graphe(10, 15);
    }

    @Test
    //crée un soldat et verifie qu'en faisant un deplacementhasard elle se trouve dans une des 4 cases autour
    void deplacementHasard()
    {
        Random rdm = new Random();
        int x = rdm.nextInt(15);
        int y = rdm.nextInt(10);

        Soldier s = new Soldier(x, y, g);
        g.getTabGrid()[x][y].add(s);
        s.deplacementHasard();
        assertTrue(
                (s.getX()==x && s.getY()==y-1) ||
                (s.getX()==x && s.getY()==y+1) ||
                (s.getX()==x-1 && s.getY()==y) ||
                (s.getX()==x+1 && s.getY()==y)
        );

    }
}