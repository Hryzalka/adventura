package com.github.Hryzalka.adventura.logika;
/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */


/*******************************************************************************
 * Instance třídy PrikazSnez implementují pro hru příkaz Snez.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author    Aleš Sedlák
 * @version   2017
 */
public class PrikazSnez implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================

    private static final String NAZEV = "snez";
    private Hra hra;
    private HerniPlan herniPlan;
    private Batoh batoh;
    
    // tento string se vyskytuje vícekrát, uděláme z něj tedy konstantu
    String nelzePouzit = "\nTohle teď nemůžu sežrat.";
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     *  
     *   @param hra       hra, která řídí celkový průběh 
     */
    public PrikazSnez(Hra hra)
    {
        this.hra = hra;
        this.herniPlan = hra.getHerniPlan();
        batoh = herniPlan.getBatoh();
    }

    //== Nesoukromé metody (instancí i třídy) ======================================

    /**
     * Metoda provede příkaz sněz
     * 
     */
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            return "\nCo mám sníst";
        }
        
        String vypis;
        String vecKJidlu = parametry[0];
        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        Batoh batoh = herniPlan.getBatoh();
        
        if (aktualniProstor.getNazev().equals("stadion") && vecKJidlu.equals("steak") && batoh.obsahujeVec("steak")) {           
            
            batoh.smazVec("steak");
            vypis = "\nTo byl dobrej steak";
        }
        else {
            vypis = "\nJeště nemůžu jíst, nejsem na stadionu nebo nemám steak u sebe";
        }
        
        return vypis;
    }

    /**
     * Metoda vrací název příkazu
     * 
     * @return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }


    
    //== Soukromé metody (instancí i třídy) ========================================

}
