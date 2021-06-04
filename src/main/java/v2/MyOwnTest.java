package v2;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyOwnTest {

    void run(AntFacadeController controller)
    {
        //testZigZag(controller);
        testConditionsNormales(controller);
    }

    private void testConditionsNormales(AntFacadeController controller)
    {
        int width = 10;
        int height = 10;
        controller.setParameters(10, 5, 200);
        controller.setAntFile("recordFile.csv");

        controller.createGrid(width, height);
        controller.createColony(6, 6);


        controller.putObstacle(2, 3);
        controller.putObstacle(7, 2 );

        controller.putFood(1, 4, 25);


        controller.createSoldiers(3);
        controller.createWorkers(3);


        Display w = new Display( width, height, 50);

        w.update( controller.play( 1000, true ) );
        /*while(true)
        {
            w.update( controller.play( 1, true ) );
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }

    private void testZigZag(AntFacadeController controller)
    {
        int width = 13;
        int height = 19;
        controller.setParameters(1, 5, 5);

        controller.createGrid(width, height);
        controller.createColony(0, 0);
        controller.createWorkers(1);
        controller.putFood(18, 0, 9);

        int j;
        boolean decalage = false;

        for (int i=0; i<19; i++)
            if (i%2 != 0)
            {
                if (decalage)
                    j = 1;
                else
                    j = 0;

                decalage = !decalage;

                for (int k=j; k<12+j; k++)
                    controller.putObstacle(i, k);
            }


        Display w = new Display( width, height, 50);
        /*BitSet[][] bs = controller.play(276, false);
        w.update(bs); //138 déplacements avant qu'elle soit sur la case voulue
        System.out.println(bs[0][0].get(3));*/

        //Le @BeforeEach pose problème pour le changement des paramètres de nourriture et de phéromone, donc on recrée tout :
        width = 13;
        height = 19;
        controller.setParameters(1, 10, 138);
        controller.createGrid(width, height);
        controller.createColony(0, 0);
        controller.createWorkers(1);

        decalage = false;

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
        BitSet[][] bs = controller.play(280, false); //aller-retour

        w.update(bs);

        /*while(true)
        {
            w.update( controller.play( 1, false ) );
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
