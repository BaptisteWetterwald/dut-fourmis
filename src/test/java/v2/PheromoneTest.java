package v2;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PheromoneTest {
    Graphe g;
    Pheromone p;
    @BeforeEach
    void setUp() {
        g = new Graphe(10,20);
        p = new Pheromone(3,5,g);

    }

    @Test
    void getQuantity() {
        assertEquals(5,p.getQuantity());
    }

    @Test
    void setQuantity() {
        p.setQuantity(37);
        assertEquals(37,p.getQuantity());
    }

    @Test
    void evaporate() {
        p.evaporate(2);
        assertEquals(3,p.getQuantity());
    }
}