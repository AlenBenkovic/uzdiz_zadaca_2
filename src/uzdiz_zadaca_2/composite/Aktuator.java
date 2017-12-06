/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.composite;

import java.util.ArrayList;
import java.util.List;
import uzdiz_zadaca_2.utils.RandomNumber;

/**
 *
 * @author abenkovic
 */
public class Aktuator extends Uredjaj implements Foi {

    private List<Senzor> senzori;

    public Aktuator(String naziv, int tip, int vrsta, float min, float max, String komentar) {
        super(naziv, tip, vrsta, min, max, komentar);
        this.senzori = new ArrayList<Senzor>();
    }

    @Override
    public void provjera() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(Senzor senzor) {
        this.senzori.add(senzor);
    }

    public void remove(Senzor senzor) {
        this.senzori.remove(senzor);
    }

    public List<Senzor> getSenzori() {
        return senzori;
    }

    public void setSenzori(List<Senzor> senzori) {
        this.senzori = senzori;
    }


    @Override
    public void pridruzenostUredjaja() {
        String poruka = "\n-------------------------------------------------------------"
                + "\n[Aktuator] " + this.id + " " + this.naziv + " pridruzeni su senzori:  "
                + "\n-------------------------------------------------------------";
        for (Senzor s : this.senzori) {
            poruka = poruka + "\n" + s.id + " " + s.naziv;
        }
        super.logger.log(poruka, "info");
    }
    
    

}
