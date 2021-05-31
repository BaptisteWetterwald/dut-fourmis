package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        g = new Graphe(1, 9);
        c = new Colony(0, 0, g, 1, 5);
        g.getTabGrid()[0][0].add(c);
        w = new Worker(0, 0, g, c);
        g.getTabGrid()[0][0].add(w);
        w.getListeCasesParcourues().add(new int[]{w.getX(), w.getY()});

        for (int i=0; i<8; i++)
        {
            w.seDeplacer();
            System.out.println("Parcourues : " + toString(w.getListeCasesParcourues()));
        }
        System.out.println("Carried = " + w.getCarried());

        ArrayList<int[]> listeTheorie = new ArrayList<>();

        for (int i=0; i<=8; i++)
            listeTheorie.add(new int[]{0, i});

        boolean same = true;
        int biggerSize = listeTheorie.size();
        if (w.getListeCasesParcourues().size() > biggerSize)
        {
            biggerSize = w.getListeCasesParcourues().size();
            System.out.println("pas la mm taille");
        }

        for (int i=0; i<biggerSize && same; i++)
        {
            System.out.println("Théorie : [" + listeTheorie.get(i)[0] + ", " + listeTheorie.get(i)[1] + "]");
            System.out.println("Pratique : [" + w.getListeCasesParcourues().get(i)[0] + ", " + w.getListeCasesParcourues().get(i)[1] + "]");
            if (listeTheorie.get(i)[0]!=w.getListeCasesParcourues().get(i)[0] || listeTheorie.get(i)[1]!=w.getListeCasesParcourues().get(i)[1])
                same = false;
        }
        assertTrue(same);
    }

    @Test
    void getListeCasesParcourues()
    {
        g = new Graphe(1, 9);
        c = new Colony(0, 0, g, 1, 5);
        g.getTabGrid()[0][0].add(c);
        w = new Worker(0, 0, g, c);
        g.getTabGrid()[0][0].add(w);
        w.getListeCasesParcourues().add(new int[]{w.getX(), w.getY()});

        for (int i=0; i<8; i++)
        {
            w.seDeplacer();
            System.out.println("Parcourues : " + toString(w.getListeCasesParcourues()));
        }
        System.out.println("Carried = " + w.getCarried());

        ArrayList<int[]> listeTheorie = new ArrayList<>();

        for (int i=0; i<=8; i++)
            listeTheorie.add(new int[]{0, i});

        boolean same = true;
        int biggerSize = listeTheorie.size();
        if (w.getListeCasesParcourues().size() > biggerSize)
        {
            biggerSize = w.getListeCasesParcourues().size();
            System.out.println("pas la mm taille");
        }

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

    @Test
    void testCheminZigzag() //Ce n'est pas une méthode que l'on a utilisée mais on a voulu retester avec le parcours de la V1
    {
        GameController controller = new GameController();

        int width = 13;
        int height = 19;
        controller.setParameters(1, 5, 5);

        controller.createGrid(width, height);
        controller.createColony(0, 0);
        controller.createWorkers(1);


        int j = 0;
        boolean decalage = false;

        for (int i=0; i<19; i++)
        {
            if (i%2 != 0)
            {
                if (decalage)
                    j = 1;
                else
                    j = 0;

                decalage = !decalage;

                for (int k=j; k<12+j; k++)
                {
                    controller.putObstacle(i, k);
                }
            }
        }


        assertTrue(controller.play(138, false)[18][0].get(3));
    }

}