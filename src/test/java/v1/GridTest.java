package v1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    @BeforeEach
    void setUp() {
        Grid g = new Grid(10,23);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
        //crée une grid et verifie que le x y et grid sont bien ceux que tu as mis
    void grid()
    {

    }
    @Test
        // tu crée une fourmiliere et tu fais un assert equal entre la position que tu as donnée et celle que te renvoie le programme
    void getFourmiliere() {

    }

    @Test
    //tu donne crée des fourmis et tu verifie a chaque case donnée par ta list que ta case contient une fourmis(bitset par ex)
    void getListFourmis() {
    }

    @Test
    // jsp mais test si la grille que tu as  et celle qui est renvoyé par gettabgrid sont les memes
    void getTabGrid() {
    }

    @Test
    // crée une fourmilière à des coordonnés x et y et verifie si sur ton graphe aux coordonnées x et y il y a une fourmilière si le contientFourmilière return true
    void contientFourmiliere() {


    }

    @Test
    // crée un obstacle à des coordonnés x et y et verifie si sur ton graphe aux coordonnées x et y il y a un obstacle si le contientObstacle return true
    void contientObstacle() {
    }

    @Test
    // crée un soldat à des coordonnés x et y et verifie si sur ton graphe aux coordonnées x et y il y a un soldat si le contientsoldat return true
    void contientSoldat() {
    }

    // il y aurait fill mais je sais pas si c'est nécessaire de test celle la
}