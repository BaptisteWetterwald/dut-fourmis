package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChoixDestinationTest {

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
    void nn()
    {

    }

    @Test
    void diagonale()
    {

    }

    @Test
    void probaPhero()
    {

    }
}
