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
    public int id;
    
    List<Uredjaj> uredjaji; // privremena lista uredjaja, dok se senzori ne dodjele aktuatoru
    List<Aktuator> aktuatori;

    public Mjesto(String naziv, int tip, int brojSenzora, int brojAktuatora) {
        this.aktuatori = new ArrayList<>();
        this.naziv = naziv;
        this.tip = tip;
        this.brojSenzora = brojSenzora;
        this.brojAktuatora = brojAktuatora;
        this.id = RandomNumber.dajSlucajniBroj(1, 1000);
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
    
    public void add(Uredjaj uredjaj){
        this.uredjaji.add(uredjaj);
    }
    
    public void remove(Uredjaj uredjaj){
        this.uredjaji.remove(uredjaj);
    }

    public List<Aktuator> getAktuatori() {
        return aktuatori;
    }

    public void setAktuatori(List<Aktuator> aktuatori) {
        this.aktuatori = aktuatori;
    }

    public List<Uredjaj> getUredjaji() {
        return uredjaji;
    }

    public void setUredjaji(List<Uredjaj> uredjaji) {
        this.uredjaji = uredjaji;
    }
    
    
    
    
}
