package v1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColonyTest {
    Grid g;
    @BeforeEach
    void setUp() {
        g = new Grid( 5, 10);
        Colony c = new Colony(2,4,g);

    }

    @AfterEach
    void tearDown() {


    }

    @Test
        //crée une colony et verifie que le x y et grid sont bien ceux que tu as mis
    void colony()
    {

        assertEquals(g.getFourmiliere());
    }

    @Test
    // tu crée une reine et tu fais un assert equal entre la position que tu as donnée et celle que te renvoie le programme
    void getReine() {

    }
}