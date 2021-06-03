package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Scenario2
{

    Graphe g;
    Colony c;
    Worker w;

    @BeforeEach
    void setUp()
    {
        g = new Graphe(3, 3);
        c = new Colony(1, 0, g, 1, 5);
        g.getTabGrid()[1][0].add(c);
        w = new Worker(1, 0, g, c);
        g.getTabGrid()[1][0].add(w);
        g.getTabGrid()[0][0].add(new Obstacle(0, 0, g));
        g.getTabGrid()[2][0].add(new Obstacle(2, 0, g));

        Pheromone p = new Pheromone(0, 1, g);
        p.setQuantity(2);
        g.getTabGrid()[0][1].add(p);

        p = new Pheromone(1, 2, g);
        p.setQuantity(1);
        g.getTabGrid()[1][2].add(p);

        g.putFood(0, 2, 100);
        g.putFood(2, 2, 100);
    }

    @Test
    void testA()
    {
        w.seDeplacer();
        assertEquals(1, w.getX());
        assertEquals(1, w.getY());
    }

    @Test
    void testB()
    {
        w.seDeplacer();
        w.seDeplacer();

        boolean caseValide = false;
        if (w.getX()==0 && w.getY()==1) //Haut
            caseValide = true;
        else if (w.getX()==1 && w.getY()==2) //Droite
            caseValide = true;
        else if (w.getX()==2 && w.getY()==1) //Bas
            caseValide = true;

        assertTrue(caseValide);
    }

    @Test
    void testC()
    {
        int nbHaut = 0;
        int nbDroite = 0;
        int nbBas = 0;

        w.seDeplacer();

        for (int i=0; i<6000; i++)
        {
            w.deplacerVers(1, 1);
            w.getListeCasesParcourues().clear();
            w.getListeCasesParcourues().add(new int[]{1, 0});
            w.seDeplacer();
            switch (w.getX())
            {
                case 0:
                    nbHaut++;
                    break;
                case 1:
                    nbDroite++;
                    break;
                case 2:
                    nbBas++;
                    break;
            }
        }

        double probaHaut = ((double)nbHaut)/6000;
        double probaDroite = ((double)nbDroite)/6000;
        double probaBas = ((double)nbBas)/6000;

        System.out.println("Haut : " + nbHaut + ", proba : " + probaHaut);
        System.out.println("Droite : " + nbDroite + ", proba : " + probaDroite);
        System.out.println("Bas : " + nbBas + ", proba : " + probaBas);

        assertTrue(probaBas<probaDroite && probaDroite<probaHaut); //probaBas < probaDroite < probaHaut
        assertTrue(0.47<probaHaut && probaHaut<0.53); //probaHaut ~= 1/2
        assertTrue(0.30<probaDroite && probaDroite<0.36); //probaDroite ~= 1/3
        assertTrue(0.14<probaBas && probaBas<0.20); //probaHaut ~= 1/6
    }
}
