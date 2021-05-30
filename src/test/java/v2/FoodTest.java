package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest
{

    Graphe g;

    @BeforeEach
    void setUp()
    {
        g = new Graphe(10,10);
        g.putFood(2, 3, 10);
    }

    @Test
    void getQuantity()
    {
        Food f = g.getFoodAt(2, 3);
        assertEquals(10, f.getQuantity());
    }

    @Test
    void setQuantity()
    {
        int q1 = g.getFoodAt(2, 3).getQuantity();
        g.getFoodAt(2, 3).setQuantity(q1 + 1);
        assertEquals(q1 + 1, g.getFoodAt(2, 3).getQuantity());
    }
}