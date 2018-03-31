package com.github.Hryzalka.adventura.logika;

/**
 *  Třída PrikazNapoveda implementuje pro hru příkaz napoveda.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Aleš Sedlák
 *@version    2017
 *  
 */
class PrikazNapoveda implements IPrikaz {
    
    private static final String NAZEV = "napoveda";
    private SeznamPrikazu platnePrikazy;
    
     /**
    *  Konstruktor třídy
    *  
    *  @param platnePrikazy seznam příkazů,
    *                       které je možné ve hře použít,
    *                       aby je nápověda mohla zobrazit uživateli. 
    */    
    public PrikazNapoveda(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }
    
    /**
     *  Vrací nápovědu po zadání příkazu "napoveda". 
     *  
     *  @return napoveda ke hre
     */
    @Override
    public String proved(String... parametry) {
        Batoh batoh = new Batoh();
        return
        "Máš za úkol jít si zahrát hokej a k tomu získat potřebné předměty\n"  
        + "Cestou se musíš zastavit v obchodě s hokejovým vybavením a jídelnou aby ses posilnil\n"
        + "Cílem je získat věechny věci a vstoupit na stadion\n"
        + "S sebou můžeš vzít maximálně " + batoh.getMaxVeci() + " předměty.\n"
        + "PŘÍKAZY:" + platnePrikazy.vratNazvyPrikazu();
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

}
