package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

public class Scenario1
{
    AntFacadeController controller;

    @BeforeEach
    void setUp()
    {
        controller = new GameController();
        int width = 13;
        int height = 19;
        controller.setParameters(1, 5, 5);
        controller.createGrid(width, height);
        controller.createColony(0, 0);
        controller.createWorkers(1);

        int j;
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
    }

    @Test
    void testA()
    {
        try
        {
            controller.putFood(0, 0, 20);
            fail("Il n'y a pas eu d'exception lancée");
        }
        catch (IllegalArgumentException e)
        {
            //C'est bon
        }
        catch (Exception e)
        {
            fail("L'exception n'est pas du type IllegalArgument");
        }
    }

    @Test
    void testB()
    {
        try
        {
            controller.putObstacle(0, 0);
            fail("Il n'y a pas eu d'exception lancée");
        }
        catch (IllegalArgumentException e)
        {
            //C'est bon
        }
        catch (Exception e)
        {
            fail("L'exception n'est pas du type IllegalArgument");
        }
    }

    @Test
    void testC()
    {
        controller.putFood(0, 1, 5);
        try
        {
            controller.putObstacle(0, 1);
            fail("Il n'y a pas eu d'exception lancée");
        }
        catch (IllegalArgumentException e)
        {
            //C'est bon
        }
        catch (Exception e)
        {
            fail("L'exception n'est pas du type IllegalArgument");
        }
    }

    @Test
    void testD()
    {
        assertTrue(controller.play(1, false)[0][1].get(3)); //S'il y a bien une ouvrière vide en 0, 1 après une itération
    }

    @Test
    void testE()
    {
        controller.putObstacle(0, 1);
        BitSet[][] bs = controller.play(1, false);
        assertTrue(bs[0][0].get(3)); //S'il y a bien une ouvrière vide en 0, 0 après une itération
        assertFalse(bs[0][1].get(3)); //On vérifie qu'il n'y en a pas en 0, 1
    }

    @Test
    void testF()
    {
        controller.putFood(18, 0, 5);
        controller.setParameters(0, 5, 1); //On passe le param d'évaporation à 0

        BitSet[][] bs = controller.play(138, false); //138 déplacements avant qu'elle soit sur la case de la nourriture
        assertTrue(bs[18][0].get(4)); //Fourmi porteuse sur la case de la nourriture

        bs = controller.play(138, false); //138 déplacements avant qu'elle soit revenue à la fourmilière
        assertTrue(bs[0][0].get(3)); //Fourmi vide sur la case de la fourmilière

        boolean pheromonesSurTouteLaGrille = true;
        for (int i=0; i<18; i++) //lignes
            for (int j=0; j<13; j++) //colonnes
                if (!bs[i][j].get(0) && !bs[i][j].get(1) && !bs[i][j].get(5)) //si ni obstacle, ni fourmilière, ni nourriture sur la case
                    if (!bs[i][j].get(6)) //S'il n'y a pas de phéromone
                        pheromonesSurTouteLaGrille = false;
        assertTrue(pheromonesSurTouteLaGrille);
    }

    @Test
    void testG()
    {
        controller.putFood(0, 2, 51);

        //Param de nourriture initialisé à 5, donc 11 allers-retours nécessaires

        int nbAllersRetours = 0;
        BitSet[][] bs = controller.play(1, false);
        while (bs[0][2].get(5)) //tant qu'il y a de la nourriture en 0, 2
        {
            bs = controller.play(1, false);
            if (bs[0][0].get(3)) //si la fourmi est de retour à la fourmilière
                nbAllersRetours++;
        }

        controller.play(2, false); //2 déplacements pour retourner à la fourmilière
        nbAllersRetours++;

        assertEquals(11, nbAllersRetours);
    }

    @Test
    void testH()
    {
        controller.putFood(0, 12, 10);
        controller.play(12, false); //arrivée sur la case de la nourriture

        controller.putObstacle(0, 10);
        BitSet[][] bs = controller.play(2, false); //si pas d'obstacle, elle devrait être en 0, 10

        assertFalse(bs[0][10].get(4)); //on vérifie qu'il n'y a pas de fourmi en 0, 10
    }

    @Test
    void testI()
    {
        //Le @BeforeEach pose problème pour le changement des paramètres de nourriture et de phéromone, donc on recrée tout :
        int width = 13;
        int height = 19;
        controller.setParameters(1, 10, 138); //138 déplacements au retour
        controller.createGrid(width, height);
        controller.createColony(0, 0);
        controller.createWorkers(1);

        int j;
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
        //Fin du setup

        controller.putFood(18, 0, 10);

        BitSet[][] bs = controller.play(276, false); //aller-retour

        ArrayList<int[]> listePositions = new ArrayList<>();
        boolean leftToRight = true;
        for (int i=0; i<height; i++)
        {
            if (i%2 == 0) //Ligne paire
            {
                if (leftToRight)
                    for (j=0; j<width; j++)
                        listePositions.add(new int[]{i, j});
                else
                    for (j=width-1; j>=0; j--)
                        listePositions.add(new int[]{i, j});
                leftToRight = !leftToRight;
            }
            else //Ligne impaire
            {
                if (!leftToRight)
                    j = width-1;
                else
                    j = 0;
                listePositions.add(new int[]{i, j});
            }
        }
        listePositions.remove(listePositions.size()-1);
        listePositions.remove(0);

        for (int i=listePositions.size()-1; i>=1; i--)
        {
            int[] position = listePositions.get(i);
            int x1 = position[0];
            int y1 = position[1];

            assertFalse(bs[x1][y1].get(6)); //Pas de pheromone dans la dernière case

            int[] positionPrecedente = listePositions.get(i-1);
            int x2 = positionPrecedente[0];
            int y2 = positionPrecedente[1];

            assertTrue(bs[x2][y2].get(6)); //Des phéromones dans l'avant-derniere case

            /*
            System.out.println("---------------");
            System.out.println("x1:" + x1 + ", y1:" + y1 + " - " + bs[x1][y1].get(6));
            System.out.println("x2:" + x2 + ", y2:" + y2 + " - " + bs[x2][y2].get(6));
            */

            bs = controller.play(1, false);
        }
    }

    /*private void display(ArrayList<int[]> list)
    {
        for (int i = 0; i < list.size(); i++)
            System.out.println("[" + list.get(i)[0] + ", " + list.get(i)[1] + "]");
    }*/
}
