/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.composite;

import java.util.ArrayList;
import java.util.List;
import uzdiz_zadaca_2.logs.FoiLogger;
import uzdiz_zadaca_2.utils.RandomNumber;

/**
 *
 * @author abenkovic
 */
public class Mjesto implements Foi {

    private final FoiLogger logger = FoiLogger.getInstance();
    public String naziv;
    public int tip;
    public int brojSenzora;
    public int brojAktuatora;
    public int id;

    List<Uredjaj> uredjaji; // privremena lista uredjaja, dok se senzori ne dodjele aktuatoru
    List<Aktuator> aktuatori;

    public Mjesto(String naziv, int tip, int brojSenzora, int brojAktuatora) {
        this.uredjaji = new ArrayList<>();
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

    public void add(Aktuator aktuator) {
        this.aktuatori.add(aktuator);
    }

    public void remove(Aktuator aktuator) {
        this.aktuatori.remove(aktuator);
    }

    public void addUredjaj(Uredjaj uredjaj) {
        this.uredjaji.add(uredjaj);
    }

    public void removeUredjaj(Uredjaj uredjaj) {
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

    @Override
    public boolean inicijalizacija() {
        ArrayList<Uredjaj> neispravniUredjaji = new ArrayList<Uredjaj>();
        for (Uredjaj uredjaj : this.uredjaji) {
            if (!uredjaj.inicijalizacija()) {
                this.logger.log(uredjaj.naziv + " [0]", "warning");
                neispravniUredjaji.add(uredjaj);
            } else {
                this.logger.log(uredjaj.naziv + " [1]", "info");
            }
        }

        for (Uredjaj neispravniUredjaj : neispravniUredjaji) {
            this.uredjaji.remove(neispravniUredjaj);
        }
        return true;
    }

    public void opremanjeMjesta() {
        ArrayList<Senzor> senzori = new ArrayList<>();

        for (Uredjaj uredjaj : this.uredjaji) {
            if (uredjaj instanceof Aktuator) {
                this.add((Aktuator) uredjaj);
            } else {
                senzori.add((Senzor) uredjaj);
            }
        }

        String poruka = "";

        for (Aktuator aktuator : this.aktuatori) {
            for (int i = 1; i <= RandomNumber.dajSlucajniBroj(1, this.brojSenzora); i++) {
                Senzor senzor = senzori.get(RandomNumber.dajSlucajniBroj(0, senzori.size() - 1));
                
                // ukoliko je aktuatoru vec pridruzen senzor, preskoci ga
                if (!aktuator.getSenzori().contains(senzor)) {
                    senzor.add(aktuator);
                    aktuator.add(senzor);
                }

            }

        }
        this.pridruzenostUredjaja();
    }

    public void pridruzenostUredjaja() {
        for (Aktuator a : this.aktuatori) {
            a.pridruzenostUredjaja();

        }
    }

}
