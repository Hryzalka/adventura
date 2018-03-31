package com.github.Hryzalka.adventura.logika;
import java.util.*;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Aleš Sedlák
 * @version 2017
 */
public class Prostor {

    private String nazev;
    private String kratkyPopis;
    private String uvodniPopis;
    private Set<Prostor> vychody;           // obsahuje seznam sousedních místností
    private List<Vec> seznamVeci;           // obsahuje list všech viditelných předmětů v prostoru

    /**
     * Vytvoření prostoru se zadaným popisem, např. "kuchyň", "hala", "trávník
     * před domem"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     */
    public Prostor(String nazev, String kratky, String uvodni) {
        this.nazev = nazev;
        this.kratkyPopis = kratky;
        this.uvodniPopis = uvodni;
        vychody = new HashSet<>();
   
        seznamVeci = new ArrayList<Vec>();
    }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). 
     *
     * @param vedlejsi prostor, který sousedi s aktuálním prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
      @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů. 
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

       return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }
      

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;       
    }
    
    /**
     * Vrací dlouhý popis prostoru
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        
      return "\nPrávě jsi " + kratkyPopis + uvodniPopis + 
                     popisVychodu();
            
    }

  
    
    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "VÝCHODY: hala ", ale pouze pokud seznam není prázdný.
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    private String popisVychodu() {
        String popis = "";
        if(!vychody.isEmpty()) {
            popis = "\nVÝCHODY:";
            for (Prostor aktualni: vychody) {
                if (!popis.equals("\nVÝCHODY:")) {
                    //pro větší přehlednost dáme čárku
                    popis += ",";
                }
                popis += " " + aktualni.getNazev();
            }
        }
        return popis;
    }
    
    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        if (nazevSouseda == null) {
            return null;
        }
        for (Prostor sousedni : vychody) {
            if (sousedni.getNazev().equals(nazevSouseda)) {
                return sousedni;
            }
        }
        return null;  // prostor nenalezen
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }
    
    /**
     * Vrací kolekci obsahující objekty v prostoru. Do ní se nezahrnují věci
     * v jiných věcech
     *
     * @return seznam objektů.
     */
    public Collection<Vec> getSeznamVeci() {
        return seznamVeci;
    }
    
    /**
     * Metoda vloží věc do prostoru
     *
     * @param vkladana  vkládaná věc
     * @return true     pokud se ji podaří vložit
     */
    public boolean vlozVec(Vec vkladana){
        seznamVeci.add(vkladana);
        return true;
    }
    
    /**
     * Metoda vrací odkaz na věc, kterou vymaže ze seznamu
     * věcí v místnosti
     *
     * @return vrátí vybranou věc
     */
    public Vec seberVec(String nazev) {
        Vec sbirana = null;
        for (Vec aktualni: seznamVeci) {
            if (nazev.equals(aktualni.getNazev()) && aktualni.isPrenositelna()){
                sbirana = aktualni;
                seznamVeci.remove(aktualni);
                break;
            }
        }
        return sbirana;
    }

    /**
     * Vrací věc, pokud se nachází v místnosti podle názvu.
     *
     * @param nazev     název hledané věci
     * @return hledana  vrátí odkaz na věc pokud tu je. null pokud tu věc není
     */
    public Vec obsahujeVec(String nazev) {
        Vec hledana = null;
        for (Vec aktualni: seznamVeci) {
            if (aktualni.getNazev().equals(nazev)) {
                hledana = aktualni;
                return hledana;
            }
        }
        return hledana;
    }

}
