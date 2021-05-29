package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    Worker w;
    Graphe g;
    Colony c;
    Food f;
    Pheromone p;
    int qty;
    @BeforeEach
    void setUp() {
        g = new Graphe(10,20);
        c = new Colony(4,8,g,7,6);
        w = new Worker(2,5,g,c);
        f= new Food(4,8,g);
        p = new Pheromone(7,9,g);

    }

    @Test
    void depositPheromone() {
        w.depositPheromone();
        //assertEquals(7,p.getQuantity());
    }

    @Test
    void takeFood() {
        w.takeFood();
        //assertEquals(3,f.getQuantity());
        assertEquals(6,w.getCarried());
    }

    @Test
    void seDeplacer() {
    }

    @Test
    void getListeCasesParcourues() {
    }

    @Test
    void getCarried() {
        w.takeFood();
        assertEquals(6,w.getCarried());
    }
}