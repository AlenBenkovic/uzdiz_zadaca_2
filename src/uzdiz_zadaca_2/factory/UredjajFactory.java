/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import uzdiz_zadaca_2.composite.Mjesto;
import uzdiz_zadaca_2.composite.Uredjaj;
import uzdiz_zadaca_2.logs.FoiLogger;
import uzdiz_zadaca_2.utils.Params;

/**
 *
 * @author abenkovic
 */
public class UredjajFactory extends FoiFactory {
    FoiLogger logger = FoiLogger.getInstance();
    ArrayList<String[]> popisSenzora;
    ArrayList<String[]> popisAktuatora;

    public UredjajFactory(HashMap params) {
        this.popisAktuatora = new ArrayList<>();
        this.popisSenzora = new ArrayList<>();
        this.ucitajPopisUredjaja(true); // ucitavam senzore
        this.ucitajPopisUredjaja(false); // ucitavam aktuatore
    }

    @Override
    public Uredjaj kreirajUredjaj(boolean isSenzor, int tip) {

       return null;
    }
    
    public void ucitajPopisUredjaja(boolean isSenzor) {
        try {
            FileReader fr = new FileReader(isSenzor ? Params.params.get("-s").toString() : Params.params.get("-a").toString());
            BufferedReader br = new BufferedReader(fr);
            String s;
            int brojAtributa = 0;
            while ((s = br.readLine()) != null) {
                String[] podatak = s.trim().split(";");
                if (brojAtributa == 0) { //prva linija je sam opis podataka i ona je mjerodavna za broj atributa
                    brojAtributa = podatak.length;
                } else if (podatak.length == brojAtributa || podatak.length == brojAtributa - 1) {
                    
                    if (isSenzor) {
                        this.popisSenzora.add(podatak);
                    } else {
                        this.popisAktuatora.add(podatak);
                    }
                 
                } else {
                     this.logger.log("Format zapisa za " + podatak[0] + " nije valjan.", "warning");
                }
            }
        } catch (IOException e) {
            System.out.println("Greska prilikom citanja datoteke: " + e.toString());
        }
        
        for(String[] s: popisAktuatora){
           System.out.println(s[0]);
        }

    }
    
    
}
