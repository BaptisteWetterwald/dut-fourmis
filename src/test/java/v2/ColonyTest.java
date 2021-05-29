package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColonyTest {
    Graphe g;
    Colony c;
    Queen q;
    @BeforeEach
    void setUp() {
        g=new Graphe(10,20);
        c= new Colony(2,4,g,7,3);
        q = new Queen(2,4,g,c);
    }

    @Test
    void getReine() {
        assertEquals(2,q.getX());
        assertEquals(4,q.getY());
        assertEquals(g,q.getGraphe());
        assertEquals(c,q.getColony());
    }

    @Test
    void getFoodWithdrawal() {
        assertEquals(3,c.getFoodWithdrawal());
    }

    @Test
    void getPheromoneDeposit() {
        assertEquals(7,c.getPheromoneDeposit());
    }
}