package com.github.Hryzalka.adventura.main;

import com.github.Hryzalka.adventura.logika.TextoveRozhrani;

public class Start
{
    /***************************************************************************
     * Metoda, prostřednictvím níž se spouští celá aplikace.
     *
     * @param args Parametry příkazového řádku
     */
    public static void main(String[] args)
    {
        
        
        TextoveRozhrani ui = new TextoveRozhrani();
        
        if(args.length == 0)
        {
            ui.hraj();
        }
        
       
        
    }
}