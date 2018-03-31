package com.github.Hryzalka.adventura.logika;
/**
 *  Třída Hra - třída představující logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Aleš Sedlák
 *@version    2017
 */

public class Hra {
    private SeznamPrikazu platnePrikazy;     // obsahuje seznam přípustných příkazů
    private HerniPlan herniPlan;
    private boolean konecHry = false;
    
    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan)
     *  a seznam platných příkazů.
     */
    public Hra() {
        herniPlan = new HerniPlan();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new PrikazNapoveda(platnePrikazy));
        platnePrikazy.vlozPrikaz(new PrikazJdi(this));
        platnePrikazy.vlozPrikaz(new PrikazKonec(this));
        platnePrikazy.vlozPrikaz(new PrikazSeber(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazInventar(herniPlan)); 
        platnePrikazy.vlozPrikaz(new PrikazZahod(herniPlan));
        platnePrikazy.vlozPrikaz(new PrikazSnez(this));
        platnePrikazy.vlozPrikaz(new PrikazVypij(this));
        platnePrikazy.vlozPrikaz(new PrikazHrajHokej(this));
       }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        return "\nVítej!.\n" +
               "Jste doma a chcete si jít zahrát hokej. Potřebujete k tomu ale několik věcí, které je nutno po cestě sesbírat.";
             //  herniPlan.getAktualniProstor().dlouhyPopis();
    }
   
    
    /** 
     * Vrací true, pokud hra skončila.
     */
     public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for(int i=0 ;i<parametry.length;i++){
            parametry[i]= slova[i+1];   
        }
        String textKVypsani=" .... ";
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.proved(parametry);
        }
        else {
            textKVypsani = "Nerozumím co chceš, zkus to napsat jinačím stylem";
        }
        return textKVypsani;
    }
    
    
     /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec.
     *  
     *  @param  konecHry  hodnota false= hra pokračuje, true = konec hry
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }
        
    /**
    *  Metoda vrátí odkaz na herní plán.
    *  
    *  @return     odkaz na herní plán
    */
    public HerniPlan getHerniPlan(){
       return herniPlan;
    }
    

    
}

