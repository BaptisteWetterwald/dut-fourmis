package v2;

public class MyOwnTest {

    void run(AntFacadeController controller)
    {
        testConditionsNormales(controller);
    }

    private void testConditionsNormales(AntFacadeController controller)
    {
        int width = 10;
        int height = 10;
        controller.setParameters(1, 5, 200);

        controller.createGrid(width, height);
        controller.createColony(6, 6);


        controller.putObstacle(2, 3);
        controller.putObstacle(7, 2 );

        controller.putFood(1, 4, 25);


        //controller.createSoldiers(3);
        controller.createWorkers(1);

        Display w = new Display( width, height, 50);

        while(true)
        {
            w.update( controller.play( 1, false ) );
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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

        while(true)
        {
            w.update( controller.play( 1, false ) );
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
