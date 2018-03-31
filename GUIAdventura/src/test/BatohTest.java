/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída BatohTest slouží ke komplexnímu otestování třídy Batoh
 *
 * @author    Aleš Sedlák
 * @version   2017
 */
public class BatohTest
{
    //== KONSTRUKTORY A TOVÁRNÍ METODY =========================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
    }

    //== VLASTNÍ TESTY =========================================================
    //
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXxx()
    //     {
    //     }
    /**
     * Testuje, zda do batohu nelze přidat víc jak maximální počet předmětů.
     */
    @Test
    public void testPridatVicJakMaximumPredmetu()
    {
        Batoh batoh2 = new Batoh();
        Vec vec1 = new Vec("vec1", true);
        Vec vec2 = new Vec("vec2", true);
        Vec vec3 = new Vec("vec3", true);
        Vec vec4 = new Vec("vec4", true);
        Vec vec5 = new Vec("vec5", true);
        Vec vec6 = batoh2.vlozVec(vec1);
        assertEquals(vec6, vec6);
        Vec vec7 = batoh2.vlozVec(vec2);
        assertEquals(vec7, vec7);
        Vec vec8 = batoh2.vlozVec(vec3);
        assertEquals(vec8, vec8);
        Vec vec9 = batoh2.vlozVec(vec4);
        assertEquals(vec9, vec9);
        Vec vec10 = batoh2.vlozVec(vec5);
        assertEquals(vec10, vec10);
        assertNull(batoh2.vlozVec(vec6));
    }

    /**
     * Testuje úspěšné vložení věci do batohu
     */
    @Test
    public void testPridejVec()
    {
        Batoh batoh1 = new Batoh();
        Vec vec1 = new Vec("vec1", true);
        assertEquals(vec1, batoh1.vlozVec(vec1));
        assertEquals(true, batoh1.obsahujeVec("vec1"));
    }

    /**
     * Testuje úspěšné smazání věci z batohu
     */
    @Test
    public void testZahodVec()
    {
        Batoh batoh1 = new Batoh();
        Vec vec1 = new Vec("vec1", true);
        batoh1.vlozVec(vec1);
        assertEquals(vec1, batoh1.smazVec("vec1"));
        assertEquals("", batoh1.getVeci());
    }
}




