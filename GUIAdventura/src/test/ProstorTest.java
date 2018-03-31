
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída ProstorTest slouží ke komplexnímu otestování
 * třídy Prostor
 *
 * @author    Aleš Sedlák
 * @version   2017
 */
public class ProstorTest
{
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
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    //== Soukromé metody používané v testovacích metodách ==========================

    //== Vlastní testovací metody ==================================================

    /**
     * Testuje, zda jsou správně nastaveny průchody mezi prostory hry. Prostory
     * nemusí odpovídat vlastní hře.
     */
    @Test
    public  void testLzeProjit() {      
        Prostor prostor1 = new Prostor("atrium", "atrium Flora",
        "atrium");
        Prostor prostor2 = new Prostor("kino", "Cinema City",
        "kino");
        prostor1.setVychod(prostor2);
        prostor2.setVychod(prostor1);
        assertEquals(prostor2, prostor1.vratSousedniProstor("kino"));
        assertEquals(null, prostor2.vratSousedniProstor("mistnost"));
    }

    /**
     * Testuje, zda lze věc úspěšně vložit do prostoru.
     */
    @Test
    public void testVlozitVecDoProstoru()
    {
        Prostor prostor1 = new Prostor("mistnost", "kratky", "uvodni");
        Vec vec1 = new Vec("vec1", true);
        assertEquals(true, prostor1.vlozVec(vec1));
        assertEquals(vec1, prostor1.obsahujeVec("vec1"));
    }
}

