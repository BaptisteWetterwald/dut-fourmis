package v2;

import java.lang.reflect.InvocationTargetException;

public class Main
{
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {

        new MyOwnTest().run(new GameController());
    }
}