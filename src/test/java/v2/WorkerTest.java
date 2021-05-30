package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

class WorkerTest
{

    Graphe g;
    Colony c;
    Worker w;

    @BeforeEach
    void setUp()
    {
        g = new Graphe(10,10);
        c = new Colony(5, 5, g, 1, 5);
        g.getTabGrid()[5][5].add(c);
        w = new Worker(4, 4, g, c);
        g.getTabGrid()[4][4].add(w);
    }

    @Test
    void depositPheromone()
    {
        Pheromone p = new Pheromone(4, 4, g);
        g.getTabGrid()[4][4].add(p);

        int qtyBefore = p.getQuantity(); // 0
        w.depositPheromone();
        assertEquals(qtyBefore + c.getPheromoneDeposit(), p.getQuantity()); //1
    }

    @Test
    void takeFood()
    {
        assertEquals(0, w.getCarried());
        g.putFood(w.getColony().getX(), w.getColony().getY(), 20);
        w.deplacerVers(w.getColony().getX(), w.getColony().getY());
        w.takeFood();
        assertEquals(w.getColony().getFoodWithdrawal(), w.getCarried());
    }

    @Test
    void seDeplacer()
    {

    }

    @Test
    void getListeCasesParcourues()
    {
        g = new Graphe(1, 5);
        c = new Colony(0, 0, g, 1, 5);
        g.getTabGrid()[0][0].add(c);
        Worker w = new Worker(0, 0, g, c);
        for (int i=0; i<4; i++)
        {
            w.seDeplacer();
            System.out.println("Parcourues : " + toString(w.getListeCasesParcourues()));
        }
        System.out.println("Carried = " + w.getCarried());

        ArrayList<int[]> listeTheorie = new ArrayList<>();
        listeTheorie.add(new int[]{0, 1});
        listeTheorie.add(new int[]{0, 2});
        listeTheorie.add(new int[]{0, 3});
        listeTheorie.add(new int[]{0, 4});

        boolean same = true;
        int biggerSize = listeTheorie.size();
        if (w.getListeCasesParcourues().size() > biggerSize)
            biggerSize = w.getListeCasesParcourues().size();

        for (int i=0; i<biggerSize && same; i++)
        {
            System.out.println("Théorie : [" + listeTheorie.get(i)[0] + ", " + listeTheorie.get(i)[1] + "]");
            System.out.println("Pratique : [" + w.getListeCasesParcourues().get(i)[0] + ", " + w.getListeCasesParcourues().get(i)[1] + "]");
            if (listeTheorie.get(i)[0]!=w.getListeCasesParcourues().get(i)[0] || listeTheorie.get(i)[1]!=w.getListeCasesParcourues().get(i)[1])
                same = false;
        }
        assertTrue(same);
    }

    private String toString(ArrayList<int[]> listeCasesParcourues)
    {
        String res = "{";
        for (int i=0; i<listeCasesParcourues.size(); i++)
        {
            res += "[" + listeCasesParcourues.get(i)[0] + ", " + listeCasesParcourues.get(i)[1] + "], ";
        }
        res = res.substring(0, res.length()-2);
        res += "}";
        return res;
    }

    @Test
    void getCarried()
    {
        assertEquals(0, w.getCarried());
        g.putFood(w.getColony().getX(), w.getColony().getY(), 20);
        w.deplacerVers(w.getColony().getX(), w.getColony().getY());
        w.takeFood();
        assertEquals(w.getColony().getFoodWithdrawal(), w.getCarried());
    }

}