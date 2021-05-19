package v2;

public class MyOwnTest {

    void run(AntFacadeController controller)
    {
        int width = 10;
        int height = 10;
        controller.createGrid(width, height);
        controller.createColony( 6,0 );

        controller.putObstacle( 2, 3);
        //controller.putObstacle( 7,2 );

        controller.createSoldiers( 10 );

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
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
