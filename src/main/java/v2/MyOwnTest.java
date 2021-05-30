package v2;

public class MyOwnTest {

    void run(AntFacadeController controller)
    {
        int width = 10;
        int height = 10;
        controller.setParameters(1, 5, 5);

        controller.createGrid(width, height);

        controller.putObstacle( 2, 3);
        controller.putObstacle( 7,2 );

        controller.putFood(1, 4, 20);

        controller.createColony( 6, 6);

        controller.createSoldiers( 3 );
        controller.createWorkers(3);

        //controller.play(1, false);
        //Display w = new Display( width, height, 10 );
        Display w = new Display( width, height, 100 );
        /*for( int i = 0; i < 100; i++)
        {
            w.update( controller.play( 1, false ) );
        }*/

        while (true)
        {
            w.update( controller.play( 1, false ) );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
