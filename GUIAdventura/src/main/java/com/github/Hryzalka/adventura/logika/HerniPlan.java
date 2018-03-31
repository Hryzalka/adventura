package com.github.Hryzalka.adventura.logika;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  
 *  -vytváří všechny prostory, propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *  
 *  -zamyká některé prostory
 *  
 *  -zakládá všechny objekty ve hře, které jsou rozmístěny 
 *  v prostorách hry. Některé může hráč vložit
 *  do touto třídou vytvořeného batohu, některé objekty
 *  v sobě mají jiné objekty
 *  
 *  
 *
 *@author     Aleš Sedlák
 *@version    2017
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Batoh batoh;
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory. Vytvoří i batoh
     *  pro hráče a nastaví zpočátku misi na nesplněnou.
     *
     */
    public HerniPlan() {
        zalozProstoryHry();
        batoh = new Batoh();
    }
    
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako aktualní prostor nastaví domov.
     *  Za pomoci jiných metod zakládá a charakterizuje postavy
     *  ve hře, stejně tak jako objekty.
     *  Metoda je následně rozmístí na dané pozice v prostorách hry.
     *  
     */
    private void zalozProstoryHry() {
        // založí a charakterizují se jednotlivé prostory s úvodními popisy
        Prostor domov = charakterizujProstor("domov");
        Prostor namesti = charakterizujProstor("namesti");
        Prostor jidelna = charakterizujProstor("jidelna");
        Prostor obchod = charakterizujProstor("obchod");
        Prostor stadion = charakterizujProstor("stadion");
        
        // založíme si pole, abychom mohli zacházet s prostory jako s celkem
        Prostor[] poleProstoru = {domov, namesti, jidelna, obchod, stadion};
        
        // nastavuje počáteční prostor
        aktualniProstor = domov;
        
        // ve hře se všem prostorům přiřadí jejich východy
        priradVychody(poleProstoru);
        
        // založí a umístí se ostatní objekty ve hře
        zalozAPriradVeci(poleProstoru);
    }
    
    /**
     * Metoda vytváří charakteristiku (popisy) jednotlivým 
     * prostorům.
     * 
     * @param nazev         jméno prostoru, který chceme charakterizovat
     * @return prostor      odkaz na nově charakterizovaný prostor
     */
    private Prostor charakterizujProstor (String nazev) {
        Prostor prostor = null;
        switch (nazev) {
            case "domov":
                prostor = new Prostor("domov","doma", 
                "\nVýchozí prostor, ze kterého vyrážíte hrát hokej");
                break;
            case "namesti":
                prostor = new Prostor("namesti", "na náměstí", 
                "\nSpojovací prostor, ze kterého můžete jít do všech ostatních prostorů.");
                break;
            case "jidelna":
                prostor = new Prostor("jidelna", "v jídelně",
                "\nProstor, kde je nezbytné sebrat redBull a steak před tím, než vyrazíte na led");
                break;
            case "obchod":
                prostor = new Prostor("obchod", "v obchodě",
                "\nProstor, kde je nezbytné vzít si hokejku a brusle před tím, než vyrazíte na led");
                break;
            case "stadion":
                prostor = new Prostor("stadion", "na stadionu", 
                "\nProstor, jenž je vaším cílem a zahrajete si zde hokej, nejdřív se ale musíte posilnit");
                break;
        }
        return prostor;
    }
    
    /**
     * Metoda přiřaďuje jednotlivým východům uloženým v poli jejich východy
     * 
     * @param prostor[]  pole prostorů
     */
    private void priradVychody(Prostor prostor[]) {
        // PROSTORY V POLI prostor[]
        // 0 = domov, 1 = namesti, 2 = jidelna, 3 = obchod, 4 = stadion
        
        prostor[0].setVychod(prostor[1]);
        prostor[1].setVychod(prostor[0]);
        prostor[1].setVychod(prostor[2]);
        prostor[1].setVychod(prostor[3]);
        prostor[1].setVychod(prostor[4]);
        prostor[2].setVychod(prostor[1]);
        prostor[3].setVychod(prostor[1]);
   
    }
    
    /**
     * Metoda zakládá všechny objekty ve hře a přiřazuje je na jejich místo.
     * Metoda přiřazuje postavy na jejich místo.
     * 
     * @param prostor[]  pole prostorů
     * 
     */
    private void zalozAPriradVeci(Prostor prostor[]) {
        // PROSTORY V POLI prostor[]
        // 0 = domov, 1 = namesti, 2 = jidelna, 3 = obchod, 4 = stadion
          
        
        
        // věci se umístí do patřičných prostorů
        prostor[1].vlozVec(new Vec ("kasna", false));
        prostor[1].vlozVec(new Vec ("lavicka", false));
        prostor[1].vlozVec(new Vec ("kytka", true));
        prostor[2].vlozVec(new Vec ("redBull", true));
        prostor[2].vlozVec(new Vec ("steak", true));
        prostor[2].vlozVec(new Vec ("zidle", false));
        prostor[2].vlozVec(new Vec ("stul", false));
        prostor[3].vlozVec(new Vec ("hokejka", true));
        prostor[3].vlozVec(new Vec ("brusle", true));
    }
    
    /**
     *  Metoda vrací batoh/inventar, který je během hry používán
     * 
     *  @return    batoh    batoh používaný ve hře
     */
    public Batoh getBatoh() {
        return this.batoh;
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *  @return     aktuální prostor
     */
    public Prostor getAktualniProstor() {
        return this.aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *  @param  prostor      nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        this.aktualniProstor = prostor;
    }
    
}
