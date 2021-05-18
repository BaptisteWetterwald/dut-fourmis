package v1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OccupantTest {
    Graphe g;
    Occupant o;
    @BeforeEach
    void setUp() {
       g= new Graphe(10,10);
        o = new Occupant(2, 4, g);
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    //tu crés un graphe et un occupant et tu regarde si le getgraphe de ton occupant est le meme que le graphe créé
    void getGraphe() {
        assertEquals(g, o.getGraphe());
    }

    @Test

    void getX() {
        assertEquals(2, o.getX());
    }

    @Test

    void getY() {
        assertEquals(2, o.getX());
    }

    @Test
    //tu crés un occupant et tu fais un get X, normalement c'est les memes et après tu fais ton SetX et tu refais un getX voir si la valeur a bien changé et si c'est la bonne
    void setX() {

        o.setX(4);
        assertEquals(4, o.getX());
    }

    @Test
    //tu crés un occupant et tu fais un get X, normalement c'est les memes et après tu fais ton SetX et tu refais un getX voir si la valeur a bien changé et si c'est la bonne
    void setY() {
        o.setX(4);
        assertEquals(4, o.getX());
    }
}