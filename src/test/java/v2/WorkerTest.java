package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    Worker w;
    Graphe g;
    Colony c;
    @BeforeEach
    void setUp() {
        g = new Graphe(10,20);
        c = new Colony(4,8,g,7,6);
        w = new Worker(2,5,g,c);

    }

    @Test
    void depositPheromone() {

    }

    @Test
    void takeFood() {
    }

    @Test
    void seDeplacer() {
    }

    @Test
    void getListeCasesParcourues() {
    }

    @Test
    void getCarried() {
    }
}