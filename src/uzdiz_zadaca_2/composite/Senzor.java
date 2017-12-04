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
public class Senzor extends Uredjaj implements Foi {

    private List<Aktuator> aktuatori;

    public Senzor(String naziv, int tip, int vrsta, float min, float max, String komentar) {
        super(naziv, tip, vrsta, min, max, komentar);
        this.aktuatori = new ArrayList<Aktuator>();
    }

    @Override
    public void provjera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean inicijalizacija() {
        return RandomNumber.dajSlucajniBroj(0, 100) < 90;
    }

    public List<Aktuator> getAktuatori() {
        return aktuatori;
    }

    public void setAktuatori(List<Aktuator> aktuatori) {
        this.aktuatori = aktuatori;
    }

    public void add(Aktuator aktuator) {
        this.aktuatori.add(aktuator);
    }

    public void remove(Aktuator aktuator) {
        this.aktuatori.remove(aktuator);
    }

    @Override
    public void pridruzenostUredjaja() {
        String poruka = "\n-------------------------------------------------------------"
                + "\nSenzor " + this.id + " " + this.naziv + " pridruzen je aktuatorima:  "
                + "\n-------------------------------------------------------------";
        for (Aktuator a : this.aktuatori) {
            poruka = poruka + "\n" + a.naziv ;
        }
        super.logger.log(poruka, "info");
    }

}
