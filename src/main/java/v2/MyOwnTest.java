package v2;

public class MyOwnTest {

    void run(AntFacadeController controller)
    {

        controller.createGrid( 10,10 );
        controller.createColony( 5,4 );

        controller.putObstacle( 2,4 );
        controller.putObstacle( 7,2 );

        controller.createSoldiers( 10 );

        //controller.play(1, false);
        Display w = new Display( 10, 10, 10 );
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
