package com.github.Hryzalka.adventura.logika;
/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */

 import java.util.*;

/*******************************************************************************
 * Instance třídy Vec představují jednotlivé věci, se kterými lze zacházet ve
 * hře
 *
 * @author    Aleš Sedlák
 * @version   2017
 */
public class Vec
{
    //== Datové atributy (statické i instancí)======================================

    private String nazev;
    private boolean sebratelna;
    
       
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     *  
     *  @param nazev        název nové věci
     *  @param sebratelna   true, pokud bude moci věc vložit do batohu
     */
    public Vec(String nazev, boolean sebratelna)
    {
        this.nazev = nazev;
        this.sebratelna = sebratelna;
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    
    /**
     * Metoda vrací název věci.
     * 
     * @return název věci
     */
    public String getNazev() {
        return this.nazev;
    }
    
    /**
     * Metoda vrací přenositelnost věci
     *
     * @return true - je-li přenositelná
     */
    public boolean isPrenositelna(){
        return this.sebratelna;
    }

}
