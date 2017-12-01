/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.composite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import uzdiz_zadaca_2.utils.RandomNumber;

/**
 *
 * @author abenkovic
 */
public class Mjesto implements Foi {
    public String naziv;
    public int tip;
    public int brojSenzora;
    public int brojAktuatora;
    public int uuid;
    
    List<Aktuator> aktuatori = new ArrayList<Aktuator>();

    public Mjesto(String naziv, int tip, int brojSenzora, int brojAktuatora) {
        this.naziv = naziv;
        this.tip = tip;
        this.brojSenzora = brojSenzora;
        this.brojAktuatora = brojAktuatora;
        this.uuid = RandomNumber.dajSlucajniBroj(1, 1000);
    }

    @Override
    public void provjera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void add(Aktuator aktuator){
        this.aktuatori.add(aktuator);
    }    
    
    public void remove(Aktuator aktuator){
        this.aktuatori.remove(aktuator);
    }

    public List<Aktuator> getAktuatori() {
        return aktuatori;
    }

    public void setAktuatori(List<Aktuator> aktuatori) {
        this.aktuatori = aktuatori;
    }
    
    
}
