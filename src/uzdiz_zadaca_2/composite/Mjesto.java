/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.composite;

import java.util.ArrayList;
import java.util.List;
import uzdiz_zadaca_2.iterator.FoiIterator;
import uzdiz_zadaca_2.logs.FoiLogger;
import uzdiz_zadaca_2.utils.Params;
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

    List<Uredjaj> uredjaji; // koristim samo jednu listu uredjaja radi prikaza pridruzenosti senzora i aktuatora,
    // radi kompozicije ovdje bi radije stavio samo aktuatore
    // ali na taj nacin cu dobiti dupli prikaz pridruzenosti senzora

    public Mjesto(String naziv, int tip, int brojSenzora, int brojAktuatora) {
        this.uredjaji = new ArrayList<>();
        this.naziv = naziv;
        this.tip = tip;
        this.brojSenzora = brojSenzora;
        this.brojAktuatora = brojAktuatora;
        this.id = RandomNumber.dajSlucajniBroj(1, 1000);
    }

    @Override
    public boolean provjera() {
        try {

            // kreiram iterator klase X na temelju korisnickog unosa
            FoiIterator iterator = (FoiIterator) Class.forName(Params.params.get("-alg").toString())
                    .getConstructor(List.class).newInstance(this.uredjaji);

            while (iterator.hasNext()) {
                Uredjaj u = (Uredjaj) iterator.next();
                if(u.provjera()){
                    this.logger.log("Radim zamjenu uredjaja", "warning");
                    this.uredjaji.add(u.zamjena());
                    this.uredjaji.remove(u);
                }
            }
        } catch (Exception e) {
            this.logger.log("Greska prilikom ucitavanja klase: " + e.getMessage(), "warning");
        }
        
        return true;
    }

    public void addUredjaj(Uredjaj uredjaj) {
        this.uredjaji.add(uredjaj);
    }

    public void removeUredjaj(Uredjaj uredjaj) {
        this.uredjaji.remove(uredjaj);
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
        ArrayList<Aktuator> aktuatori = new ArrayList<>();

        for (Uredjaj uredjaj : this.uredjaji) {
            if (uredjaj instanceof Aktuator) {
                aktuatori.add((Aktuator) uredjaj);
            } else if (uredjaj instanceof Senzor) {
                senzori.add((Senzor) uredjaj);
            }
        }

        for (Aktuator aktuator : aktuatori) {
            for (int i = 1; i <= RandomNumber.dajSlucajniBroj(1, this.brojSenzora); i++) {
                try {
                    Senzor senzor = senzori.get(RandomNumber.dajSlucajniBroj(0, senzori.size() - 1));

                    // ukoliko je aktuatoru vec pridruzen senzor, preskoci ga
                    if (!aktuator.getSenzori().contains(senzor)) {
                        senzor.add(aktuator);
                        aktuator.add(senzor);
                    }

                } catch (Exception e) {
                    this.logger.log("Greska kod dodjele senzora: " + e.toString(), "warning");
                }

            }

        }

        this.pridruzenostUredjaja();
    }

    public void pridruzenostUredjaja() {
        for (Uredjaj uredjaj : this.uredjaji) {
            uredjaj.pridruzenostUredjaja();
        }
    }

}
