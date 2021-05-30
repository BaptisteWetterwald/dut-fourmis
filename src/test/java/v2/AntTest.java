package v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AntTest
{
    Graphe g;
    Colony c;

    @BeforeEach
    void setUp()
    {
        g = new Graphe(10, 10);
        c = new Colony(5, 5, g, 1, 5);
    }

    @Test
    void seDeplacer() //Dépend des sous-classes, avec Soldier qui se déplace au hasard :
    {
        Soldier s = new Soldier(4, 4, g, c);
        ArrayList<int[]> voisins = s.getListeVoisins();
        s.seDeplacer();

        boolean surUnVoisin = false;
        for (int i=0; i<voisins.size() && !surUnVoisin; i++)
            if (s.getX()==voisins.get(i)[0] && s.getY()==voisins.get(i)[1])
                surUnVoisin = true;

        assertTrue(surUnVoisin);
    }

    @Test
    void deplacerVers()
    {
        Soldier s = new Soldier(4, 4, g, c);
        g.getTabGrid()[0][0].add(s); //Pas nécessaire mais plus logique
        s.deplacerVers(4, 5);
        assertEquals(4, s.getX());
        assertEquals(5, s.getY());
    }

    @Test
    void getColony()
    {
        Soldier s = new Soldier(4, 4, g, c);
        assertEquals(c, s.getColony());
    }

    @Test
    void getListeVoisins()
    {
        Soldier s = new Soldier(4, 4, g, c);
        g.getTabGrid()[4][3].add(new Obstacle(4, 3, g));

        ArrayList<int[]> voisins = s.getListeVoisins();
        ArrayList<int[]> voisinsPossibles = new ArrayList<>();
        voisinsPossibles.add(new int[]{3, 4});
        voisinsPossibles.add(new int[]{5, 4});
        voisinsPossibles.add(new int[]{4, 5});

        boolean voisinsCorrects = true;

        assertTrue(voisinsPossibles.size() == voisins.size());

        for (int i=0; i<voisins.size(); i++)
            if (voisins.get(i)[0]!=voisinsPossibles.get(i)[0] || voisins.get(i)[1]!=voisinsPossibles.get(i)[1]) //Si les x ou y diffèrent
                voisinsCorrects = false;

        assertTrue(voisinsCorrects);
    }
}