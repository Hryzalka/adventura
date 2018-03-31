package com.github.Hryzalka.adventura.logika;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */


/*******************************************************************************
 * Instance třídy PrikazSeber implementují pro hru příkaz Seber.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author    Aleš Sedlák
 * @version   2017
 */
public class PrikazSeber implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
    
    private static final String NAZEV = "seber";
    private HerniPlan herniPlan;
    private Batoh batoh;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     *  
     *   @param herniPlan herní plán, ve kterém se bude ve hře "chodit" 
     */
    public PrikazSeber(HerniPlan herniPlan)
    {
        this.herniPlan = herniPlan;
        this.batoh = herniPlan.getBatoh();
    }

    //== Nesoukromé metody (instancí i třídy) ======================================

    /**
     * Metoda zpracovává sebrání věci - nesebere ji, pokud tam není, nebo 
     * je-li batoh plný
     * 
     * @param   parametry   sbíraná věc
     * @return              zápis o tom, zda byla věc sebrána
     */    
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            return "\nCo mám sebrat?";
        }

        String nazevVeci = parametry[0];
        Prostor aktualniProstor = herniPlan.getAktualniProstor();

        if (aktualniProstor.obsahujeVec(nazevVeci) == null) {
            // pokud v aktuálním prostoru věc není
            return "\nNic takového tu není.";
        }
        else {
            Vec sbirana = aktualniProstor.seberVec(nazevVeci);
            if (sbirana == null) {
                // pokud věc není přenositelná
                return "\nTohle nemůžu odnést.";
            }
            else {
                if (batoh.vlozVec(sbirana) == null) {
                    // vrátí věc do prostoru, pokud je batoh plný
                    aktualniProstor.vlozVec(sbirana);
                    return "\nUž mám moc věcí.";
                }
                else {
                    // pokud se podaží věc vložit do batohu
                    return "\nSebral jsem " + nazevVeci + ".";
                }
            }
        }
    }
    
    /**
     * Metoda vrací název příkazu
     * 
     * @return  název příkazu
     */
    public String getNazev () {
        return NAZEV;
    }

    //== Soukromé metody (instancí i třídy) ========================================

}
