package com.github.Hryzalka.adventura.logika;
/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */


/*******************************************************************************
 * Instance třídy PrikazInventar implementují pro hru příkaz Inventar.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author    Aleš Sedlák
 * @version   2017
 */
public class PrikazInventar implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================

    private static final String NAZEV = "inventar";
    private HerniPlan herniPlan;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     *  
     *   @param herniPlan herní plán, ve kterém se bude ve hře "chodit" 
     */
    public PrikazInventar(HerniPlan herniPlan) {
        this.herniPlan = herniPlan;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    
    /**
     *  Provádí příkaz "inventář". Vypíše všechny věci, které jsou v batohu.
     *
     *  @return     zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String proved(String... parametry) {
        if (herniPlan.getBatoh().getVeci().isEmpty()) {
            // pokud je batoh prázdný
            return "\nZatím jsem nic nesebral.";
        }
        else {
            // pokud je v batohu jedna a více věcí.
            return "\nV batohu mám" + herniPlan.getBatoh().getVeci() + ".";
        }
    }

    /**
     *  Metoda vrací název příkazu
     *  
     *  @ return název příkazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }

    //== Soukromé metody (instancí i třídy) ========================================

}
