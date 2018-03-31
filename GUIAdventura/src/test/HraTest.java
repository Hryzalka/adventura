import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author   Aleš Sedlák
 * @version  2017
 */
public class HraTest {
    private Hra hra1;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /***************************************************************************
     * Testuje, zda se hra sama ukončí (konecHry se nastaví na true),
     * když vejdu na stadion a budu moct vyjet na led.
     */
    @Test
    public void testHraSeSamaUkonci()
    {
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi namesti");
        hra1.zpracujPrikaz("jdi obchod");
        hra1.zpracujPrikaz("seber brusle");
        hra1.zpracujPrikaz("seber hokejka");
        hra1.zpracujPrikaz("jdi namesti");
        hra1.zpracujPrikaz("jdi jidelna");
        hra1.zpracujPrikaz("seber redBull");
        hra1.zpracujPrikaz("seber steak");
        hra1.zpracujPrikaz("jdi namesti");
        hra1.zpracujPrikaz("jdi stadion");
        hra1.zpracujPrikaz("vypij redBull");
        hra1.zpracujPrikaz("snez steak");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("hrajHokej");
        assertEquals("Vyjel si na led a vyhrál jsi!\n\nDěkuji, že sis zahrál tuto hru!", hra1.zpracujPrikaz("hrajHokej"));
        assertEquals(true, hra1.konecHry());
    }

}