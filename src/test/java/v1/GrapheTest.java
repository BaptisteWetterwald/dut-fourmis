package v1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GrapheTest
{
    Graphe g;

    @BeforeEach
    void setUp()
    {
        g = new Graphe(10, 23);
    }

    @Test
    void getFourmiliere()
    {
        g.getTabGrid()[4][7].add(new Colony(4, 7, g));
        assertEquals(g.getFourmiliere(), g.getTabGrid()[4][7].get(1)); // Car la Reine occupe l'index 0
    }

    @Test
    void getListFourmis()
    {
        Queen q = new Queen(4, 4, g);
        for (int i=0; i<10; i++)
            q.donnerVie();
        ArrayList<Ant> listAntsTab = new ArrayList<>();
        for (int i=0; i<g.getTabGrid().length; i++)
            for (int j=0; j<g.getTabGrid()[0].length; j++)
            {
                for (Occupant o : g.getTabGrid()[i][j])
                {
                    if (o instanceof Ant)
                        listAntsTab.add( (Ant) o);
                }
            }
        /*System.out.println(listAntsTab);
        System.out.println();
        System.out.println(g.getListFourmis());*/
        assertEquals(listAntsTab, g.getListFourmis());
    }

    @Test
    // crée une fourmilière à des coordonnés x et y et verifie si sur ton graphe aux coordonnées x et y il y a une fourmilière si le contientFourmilière return true
    void contientFourmiliere()
    {
        g.getTabGrid()[4][4].add(new Colony(4, 4, g));
        assertTrue(g.contientFourmiliere(4, 4));
        assertFalse(g.contientFourmiliere(4, 5));
    }

    @Test
    // crée un obstacle à des coordonnés x et y et verifie si sur ton graphe aux coordonnées x et y il y a un obstacle si le contientObstacle return true
    void contientObstacle()
    {
    }

    @Test
    // crée un soldat à des coordonnés x et y et verifie si sur ton graphe aux coordonnées x et y il y a un soldat si le contientsoldat return true
    void contientSoldat()
    {
    }

    // il y aurait fill mais je sais pas si c'est nécessaire de test celle la
}