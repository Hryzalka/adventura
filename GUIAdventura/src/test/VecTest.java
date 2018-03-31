/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */


import com.github.Hryzalka.adventura.logika.Vec;
import com.github.Hryzalka.adventura.logika.Prostor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída VecTest slouží ke komplexnímu otestování třídy Vec 
 *
 * @author    Aleš Sedlák
 * @version   2017
 */
public class VecTest
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
    /**
     * Testuje zda správně funguje vkládání věcí do prostoru
     */
    @Test
    public void testVecSebratelna()
    {
        Vec vec = new Vec ("vec", false);
        Vec vec1 = new Vec ("vec1", true);
        Prostor prostor = new Prostor ("mistnost","kratky", "dlouhy"); 
        prostor.vlozVec(vec);
        prostor.vlozVec(vec1);
        assertEquals(null, prostor.seberVec("vec"));
        assertNotNull(prostor.seberVec("vec1"));
    }
}
