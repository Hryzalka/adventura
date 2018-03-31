package com.github.Hryzalka.adventura.logika;
/**
 *  Třída PrikazJdi implementuje pro hru příkaz jdi.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Aleš Sedlák
 *@version    2017
 */
class PrikazJdi implements IPrikaz {
    
    private static final String NAZEV = "jdi";
    private Hra hra;
    private HerniPlan plan;
    private Batoh batoh;
    
    /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude ve hře "chodit" 
    */    
    public PrikazJdi(Hra hra) {
        this.hra = hra;
        this.plan = hra.getHerniPlan();
        this.batoh = plan.getBatoh();
    }

    /**
     *  Provádí příkaz "jdi". Zkouší se vyjít do zadaného prostoru. Pokud prostor
     *  existuje, vstoupí se do nového prostoru. Pokud zadaný sousední prostor
     *  (východ) není, vypíše se chybové hlášení.
     *
     *@param parametry        parametr obsahuje jméno prostoru (východu),
     *                         do kterého se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String proved(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední prostor), tak ....
            return "Kam mám jít?";
        }

        String vypis = "";
        String smer = parametry[0];

        Prostor aktualniProstor = plan.getAktualniProstor();
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(smer);
        
        if (sousedniProstor == null) {
            return "Tam se odsud jít nedá!";
        }
        vypis = sousedniProstor.dlouhyPopis();
        
        if (sousedniProstor.getNazev().equals("stadion")) {
            
            if (batoh.obsahujeVec("hokejka") && batoh.obsahujeVec("brusle") && batoh.obsahujeVec("redBull") && batoh.obsahujeVec("steak"))
            {              
                plan.setAktualniProstor(sousedniProstor);
                 return vypis;
            }
            else return "Vem si nejdřív hokejku,brusle,redBull,steak!";
        }
        
         plan.setAktualniProstor(sousedniProstor);
        return vypis;
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
