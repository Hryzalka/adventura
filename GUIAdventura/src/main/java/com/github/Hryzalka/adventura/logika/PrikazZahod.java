package com.github.Hryzalka.adventura.logika;
/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */


/*******************************************************************************
 * Instance třídy PrikazZahod implementují pro hru příkaz Zahod.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author    Aleš Sedlák
 * @version   2017
 */
public class PrikazZahod implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================

    private static final String NAZEV = "zahod";
    private HerniPlan herniPlan;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     *  
     *   @param herniPlan herní plán, ve kterém se bude ve hře "chodit" 
     */
    public PrikazZahod(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }
    
    //== Nesoukromé metody (instancí i třídy) ======================================

    /**
     *  Provádí příkaz "zahod". Pokud v batohu věc není vypíše chybovou hlášku.
     *  Jinak věc odhodí do aktuálního prostoru. Je možné zahodit jen jednu věc
     *  najednou.
     *
     *  @param  parametry   jako  parametr se zadává jméno odhazované věci
     *  @return             zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            return "\nCo mám zahodit?";
        }

        String nazevVeci = parametry[0];
        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        Batoh batoh = herniPlan.getBatoh();
        Vec mazana = batoh.getVec(nazevVeci);

        if (mazana == null) {
            // pokud mazana věc není v batohu.
            return "\nTakovou věc s sebou nemám.";            
        }
        else {
            // pokud je věc smazána z batohu, přesune se do aktualního prostoru
            mazana = batoh.smazVec(nazevVeci);
            aktualniProstor.vlozVec(mazana);
            return "\nZahodil jsem " + nazevVeci + ".";
        }
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
    
    //== Soukromé metody (instancí i třídy) ========================================

}
