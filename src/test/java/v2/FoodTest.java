package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    Graphe g;
    Food f;
    @BeforeEach
    void setUp() {
        g = new Graphe(10,20);
        g.putFood(2,3,5);
        f = new Food(7,8,g);
    }

    @Test
    void getQuantity() {
        assertEquals(9,f.getQuantity());
    }

    @Test
    void setQuantity() {
        f.setQuantity(93);
        assertEquals(93,f.getQuantity());
    }
}