package com.github.Hryzalka.adventura.logika;

/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */

 import java.util.*;

/*******************************************************************************
 * Instance třídy Batoh představují kolekci věcí, které si uživatel přidal 
 * do inventáře v průběhu hraní.
 *
 * @author    Aleš Sedlák
 * @version   2017
 */
public class Batoh
{
    //== Datové atributy (statické i instancí)======================================
    
    private static final int MAX_VECI = 4;    // Maximální počet věcí v batohu
    private List<Vec> obsah;            // Seznam věcí v batohu
    
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     */
    public Batoh() {
        obsah = new ArrayList<Vec>();
    }
    
    //== Nesoukromé metody (instancí i třídy) ======================================
    
    /**
     * Metoda pro vložení věci.
     * 
     * @param   vec    vkládaná věc
     * @return  vec    vrátí tu samou věc, pokud se ji podaří přidat do batohu.
     *                 Null, pokud ne.
     */
    public Vec vlozVec(Vec pridavana) {
        if (jeMisto()) {          
            obsah.add(pridavana);
            return pridavana;
        }
        return null;
    }
    
    /**
     * Zjišťuje, zda je v batohu ještě místo.
     * 
     * @return  true   pokud místo je.
     */
     public boolean jeMisto() {
        if (obsah.size() < MAX_VECI) {
            return true;   
        }        
        return false;
    }
    
    /**
     * Zjišťuje, zda je věc v batohu.
     *  
     * @param   hledana    hledana vec
     * @return  true       pokud se věc v batohu nachází, jinak false
     */
    public boolean obsahujeVec(String hledana) {
        for (Vec aktualni: obsah) {
            if (aktualni.getNazev().equals(hledana)) {
                 return true;
            }
        }
        return false;
    }
    
    /**
     * Vrací seznam věcí v batohu
     * 
     * 
     */
    public String getVeci() {
        String seznam = "";
        for (Vec aktualni: obsah) {
            if (!seznam.equals("")) {
                //pro větší přehlednost dáme čárku
                seznam += ",";
            }
            seznam += " " + aktualni.getNazev();
        }
        return seznam;
    }
    
    /**
     * Metoda najde věc, na kterou chceme odkázat
     * 
     * @param nazev      název věci, kterou chceme najít
     * @return hledana   odkaz na nalezenou věc. Je null, pokud věc nebyla nalezena
     */
    public Vec getVec(String nazev) {
        Vec hledana = null;
        for (Vec aktualni: obsah) {
            if(aktualni.getNazev().equals(nazev)) {
                hledana = aktualni;
                break;
            }
        }
        return hledana;
    }

    public List<Vec> getObsah() {
        return obsah;
    }
    
    
    
    /**
     * Odstraní věci z inventáře
     * 
     * @param   mazana      odstraňovaná věc
     * @return  smazana     odstraněná věc. Je null, pokud věc nebyla v batohu nalezena
     */
    public Vec smazVec (String mazana) {
        Vec smazana = null;
        for(Vec aktualni: obsah) {
            if(aktualni.getNazev().equals(mazana)) {
                smazana = aktualni;
                obsah.remove(aktualni);
                break;
            }
        }
        return smazana;
    }
    
    /**
     * Metoda vrací maximální počet věcí, které lze přidat do batohu.
     * 
     * @return  počet věcí
     */
    public int getMaxVeci() {
        return MAX_VECI;
    }
    
    //== Soukromé metody (instancí i třídy) ========================================

}
