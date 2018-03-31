package com.github.Hryzalka.adventura.logika;
/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */


/*******************************************************************************
 * Instance třídy PrikazProzkoumej implementují pro hru příkaz Prozkoumej.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author    Aleš Sedlák
 * @version   2017
 */
public class PrikazVypij implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================

    private static final String NAZEV = "vypij";
    private Hra hra;
    private HerniPlan herniPlan;
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     *  
     *   @param hra       hra, která řídí celkový průběh 
     */
    public PrikazVypij(Hra hra) {
        this.hra = hra;
        this.herniPlan = hra.getHerniPlan();
    }

    //== Nesoukromé metody (instancí i třídy) ======================================

     /**
     * Metoda provede příkaz vypij
     * 
     */
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            return "\nCo mám vypít?";
        }
        
        String vypis;
        String vecKPiti = parametry[0];
        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        Batoh batoh = herniPlan.getBatoh();
        
        if (aktualniProstor.getNazev().equals("stadion") && vecKPiti.equals("redBull") && batoh.obsahujeVec("redBull")) {           
            
            batoh.smazVec("redBull");
            vypis = "\nTeď mám křídla";
        }
        else {
            vypis = "\nJeště nemůžu pít, nejsem na stadionu nebo nemám Red Bull u sebe";
        }
        
        return vypis;
    }

    /**
     *  Metoda vrací název příkazu 
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
    //== Soukromé metody (instancí i třídy) ========================================

}
