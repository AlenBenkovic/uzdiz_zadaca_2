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
import uzdiz_zadaca_2.logs.FoiLogger;

/**
 *
 * @author abenkovic
 */
public class MjestoFactory extends FoiFactory {

    FoiLogger logger = FoiLogger.getInstance();

    @Override
    public List<Mjesto> kreirajMjesta(String datoteka) {
        return this.kreiramMjestaIzDatoteke(datoteka);
    }

    private List<Mjesto> kreiramMjestaIzDatoteke(String datoteka) {
        try {
            FileReader fr = new FileReader(datoteka);
            BufferedReader br = new BufferedReader(fr);
            List<Mjesto> mjesta = new ArrayList<Mjesto>();
            String s;
            int brojAtributa = 0;
            while ((s = br.readLine()) != null) {
                
                String[] podatak = s.trim().split(";");
                
                if (brojAtributa == 0) { //prva linija je sam opis podataka i ona je mjerodavna za broj atributa
                    
                    brojAtributa = podatak.length;
                    
                } else if (podatak.length == brojAtributa) {
                    Mjesto mjesto = this.kreirajMjesto(podatak);

                    this.logger.log("Kreiram mjesto " + podatak[0] + " .", "info");
                    
                    if (postojiMjesto(podatak[0], mjesta)) {
                        
                        this.logger.log("Mjesto " + podatak[0] + " već postoji.", "warning");
                        
                    } else {
                        
                        mjesta.add(mjesto);
                        
                    }

                } else {
                    
                    this.logger.log("Zapis mjesta iz datoteke nije valjan.", "warning");
                    
                }
            }
            
            return mjesta;
            
        } catch (IOException e) {
            
            System.out.println("Greska prilikom citanja datoteke: " + e.toString());
            return null;
        }

    }

    public Mjesto kreirajMjesto(String[] podaciMjesta) {
        return new Mjesto(podaciMjesta[0],
                Integer.parseInt(podaciMjesta[1]),
                Integer.parseInt(podaciMjesta[2]),
                Integer.parseInt(podaciMjesta[3]));
    }
    
    private boolean postojiMjesto(String naziv, List<Mjesto> mjesta){
        boolean status = false;
        for (Mjesto m: mjesta){
            if(m.naziv.equals(naziv)){
                status = true;
            }
        }
        
        return status;
    }
    

}
