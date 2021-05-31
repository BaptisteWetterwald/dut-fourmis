package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DeplacementWorkerTest {
Graphe g;
Colony c;
Food f;
Obstacle o;
Obstacle eau;






    @BeforeEach
    void setUp() {
        g=new Graphe(10,20);
        c = new Colony(0,0,g,1,1);
        o = new Obstacle(3,3,g);
        f = new Food(5,5,g);

    }

    @Test
    void foodoncolony()
    {
        try
        {
            g.putFood(0,0,2);
        }
       catch(IllegalArgumentException i)
        {
            System.out.println("test  1 ok");
        }
    }

    @Test
    void foodonobstacle()
    {
        try
        {
            g.putFood(3,3,2);
        }
        catch(IllegalArgumentException i)
        {
            System.out.println("test 2 ok");
        }
    }

    @Test
    void obstacleonfood()
    {
        try
        {
            eau = new Obstacle(5,5,g);
        }
        catch(IllegalArgumentException i)
        {
            System.out.println("test 3 ok");
        }
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
