package com.github.Hryzalka.adventura.logika;

/**
/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */


/*******************************************************************************
 * Instance třídy PrikazHrajHokej implementují pro hru příkaz HrajHokej.
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author    Aleš Sedlák
 * @version   2017
 */
public class PrikazHrajHokej implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================

    private static final String NAZEV = "hrajHokej";
    private Hra hra;
    private HerniPlan herniPlan;
    private Batoh batoh;
   
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     *  
     *   @param hra       hra, která řídí celkový průběh 
     */
    public PrikazHrajHokej(Hra hra)
    {
        this.hra = hra;
        this.herniPlan = hra.getHerniPlan();
        batoh = herniPlan.getBatoh();
    }

    //== Nesoukromé metody (instancí i třídy) ======================================

    /**
     * Metoda provede příkaz hrajHokej
     * 
     */
    public String proved(String... parametry) {
        
        
        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        Batoh batoh = herniPlan.getBatoh();
        
        if (parametry.length == 0 && aktualniProstor.getNazev().equals("namesti") || (parametry.length == 0 && aktualniProstor.getNazev().equals("obchod")) || (parametry.length == 0 && aktualniProstor.getNazev().equals("domov")) || (parametry.length == 0 && aktualniProstor.getNazev().equals("jidelna"))) {
            return "Tady nemůžeš hrát hokej!";
        }
        
        if (parametry.length == 0 && aktualniProstor.getNazev().equals("stadion") && batoh.obsahujeVec("hokejka") && batoh.obsahujeVec("brusle") && !(batoh.obsahujeVec("redBull")) && !(batoh.obsahujeVec("steak"))) {
                    
            hra.setKonecHry(true);

            return ("Vyjel si na led a vyhrál jsi!\n\nDěkuji, že sis zahrál tuto hru!");
        }
        return "Nejdřív se musíš posilnit!";
       
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
