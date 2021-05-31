package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeplacementWorkerTest {


    static final int WIDTH = 10;
    static final int HEIGHT = 20;

    AntFacadeController appli;

    @BeforeEach
    void setUp() {
        appli = new GameController();
        appli.createGrid(WIDTH, HEIGHT);
        appli.createColony(0, 0);
        appli.createWorkers(1);
    }

    @Test
    void foodoncolony()
    {

    }

    @Test
    void foodonobstacle()
    {

    }

    @Test
    void obstacleonfood()
    {

    }

    @Test
    void deplacementbloque()
    {

    }

    @Test
    void alleretour()
    {

    }

    @Test
    void takeallfood()
    {

    }

    @Test
    void nogothrough()
    {

    }

    @Test
    void disparitionpheromone()
    {

    }
}
