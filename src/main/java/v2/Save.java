package v2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Save
{

    private File fileSave;

    /**
     * Constructeur classe Save
     *
     * @param name chemin d'accès (nom et extension inclus) du fichier à créer ou utiliser
     */
    public Save(String name)
    {
        fileSave = new File(name);
        try
        {
            fileSave.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            FileWriter fw = new FileWriter(fileSave.getPath());
            fw.write("Iteration,Id,Type,CarriedFood,Row,Column,Food,Pheromone");
            fw.flush();
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Permet l'enregistrement des déplacements à l'itération courante vers le fichier
     *
     * @param g graphe concerné
     * @param iteration numéro d'itération
     */
    public void saveMoves(Graphe g, int iteration)
    {
        try
        {
            FileWriter fw = new FileWriter(fileSave.getPath(), true);

            for (int i=0; i<g.getListFourmis().size(); i++)
            {
                String toPrint = String.valueOf(iteration); //Iteration
                toPrint += ",";

                Ant f = g.getListFourmis().get(i);

                toPrint += f.toString(); //Id
                toPrint += ",";

                toPrint += f.getClass().getSimpleName(); //Type
                toPrint += ",";

                if (f instanceof Worker)
                    toPrint += ((Worker) f).getCarried(); //CarriedFood
                else
                    toPrint += "-";

                toPrint += ",";
                int x = f.getX();
                toPrint += x; //x

                toPrint += ",";
                int y = f.getY(); //y
                toPrint += y;

                toPrint += ",";
                Food food = g.getFoodAt(x, y);
                if (food == null)
                    toPrint += "0";
                else
                    toPrint += food.getQuantity(); //Food

                toPrint += ",";
                Pheromone phero = g.getPheromoneAt(x, y);
                if (phero == null)
                    toPrint += "0";
                else
                    toPrint += phero.getQuantity(); //Pheromone

                fw.write("\n" + toPrint);
            }

            fw.flush();
            fw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
