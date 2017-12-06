/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.composite;

import java.util.ArrayList;
import java.util.List;
import uzdiz_zadaca_2.factory.FoiFactory;
import uzdiz_zadaca_2.factory.UredjajFactory;
import uzdiz_zadaca_2.iterator.MjestoIterator;
import uzdiz_zadaca_2.logs.FoiLogger;
import uzdiz_zadaca_2.iterator.FoiIterator;

/**
 *
 * @author abenkovic
 */
public class FoiZgrada implements Foi {

    private final FoiLogger logger = FoiLogger.getInstance();

    private List<Mjesto> mjesta = new ArrayList<>();

    @Override
    public void provjera() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(Mjesto mjesto) {
        this.mjesta.add(mjesto);
    }

    public List<Mjesto> getMjesta() {
        return mjesta;
    }

    public void setMjesta(List<Mjesto> mjesta) {
        this.mjesta = mjesta;
    }

    public FoiIterator createIterator() {
        return new MjestoIterator(this.mjesta);
    }

    @Override
    public boolean inicijalizacija() {
        FoiIterator iterator = this.createIterator();
        while (iterator.hasNext()) {
            Mjesto m = (Mjesto) iterator.next();
            String poruka = "\n-------------------------------------------------------------"
                    + "\n\tInicijaliziram uredjaje za " + m.id + " " + m.naziv
                    + "\n-------------------------------------------------------------\n";
            this.logger.log(poruka, "info");
            m.inicijalizacija();
        }
        return true;
    }

    public void postaviUredjaje() {
        FoiFactory factory = new UredjajFactory();
        for (Mjesto m : this.mjesta) {
            String poruka = "\n-------------------------------------------------------------"
                    + "\n\tPostavljam uredjaje za " + m.naziv
                    + "\n-------------------------------------------------------------\n";
            this.logger.log(poruka, "info");

            for (int i = 0; i <= m.brojSenzora; i++) {
                m.addUredjaj(factory.kreirajUredjaj(true, m.tip));
            }

            for (int i = 0; i <= m.brojAktuatora; i++) {
                m.addUredjaj(factory.kreirajUredjaj(false, m.tip));
            }
        }
    }

    public void opremanjeMjesta() {
        FoiIterator iterator = this.createIterator();
        while (iterator.hasNext()) {
            Mjesto m = (Mjesto) iterator.next();
            String poruka = "\n-------------------------------------------------------------"
                    + "\n\tOpremam mjesto " + m.id + " " + m.naziv
                    + "\n-------------------------------------------------------------\n";
            this.logger.log(poruka, "info");
            m.opremanjeMjesta();
        }
    }

}
