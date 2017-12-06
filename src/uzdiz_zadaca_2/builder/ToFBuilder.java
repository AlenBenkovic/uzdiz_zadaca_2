/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.builder;

import java.util.List;
import uzdiz_zadaca_2.composite.FoiZgrada;
import uzdiz_zadaca_2.composite.Mjesto;
import uzdiz_zadaca_2.composite.Uredjaj;
import uzdiz_zadaca_2.factory.FoiFactory;
import uzdiz_zadaca_2.factory.MjestoFactory;
import uzdiz_zadaca_2.iterator.AlgoritamNasumicno;
import uzdiz_zadaca_2.iterator.AlgoritamObrnuto;
import uzdiz_zadaca_2.iterator.AlgoritamSlijedno;
import uzdiz_zadaca_2.iterator.FoiIterator;
import uzdiz_zadaca_2.logs.FoiLogger;
import uzdiz_zadaca_2.utils.Params;

/**
 *
 * @author abenkovic
 */
public class ToFBuilder {

    private final FoiLogger logger = FoiLogger.getInstance();
    private final FoiZgrada foiZgrada;

    public ToFBuilder(Builder builder) {
        this.foiZgrada = builder.foiZgrada;
    }

    public static class Builder {

        private final FoiLogger logger = FoiLogger.getInstance();
        private final FoiZgrada foiZgrada = new FoiZgrada();

        public Builder() {
            this.logger.init(Params.params.get("-i").toString(), Integer.parseInt(Params.params.get("-brl").toString()));
        }

        public Builder kreirajMjesta() {
            FoiFactory factory = new MjestoFactory();

            factory.kreirajMjesta(Params.params.get("-m").toString()).forEach((m) -> {
                this.foiZgrada.add(m);
            });

            return this;
        }

        public Builder postaviUredjaje() {
            this.foiZgrada.postaviUredjaje();

            return this;
        }

        public Builder inicijalizacija() {
            this.foiZgrada.inicijalizacija();

            return this;
        }

        public Builder opremanjeMjesta() {
            this.foiZgrada.opremanjeMjesta();

            return this;

        }

        public ToFBuilder build() {
            return new ToFBuilder(this);
        }

    }

    public void radiProvjere() {
        Runnable dretva = () -> {
            int i = 0;
            while (i < Integer.parseInt(Params.params.get("-bcd").toString())) {
                try {
                    i++;
                    Thread.sleep(Integer.parseInt(Params.params.get("-tcd").toString()) * 1000);

                    for (Mjesto mjesto : this.foiZgrada.getMjesta()) {
                        try {
                            
                            FoiIterator iterator = (FoiIterator) Class.forName(Params.params.get("-alg").toString())
                                    .getConstructor(List.class).newInstance(mjesto.getUredjaji());
                            
                            while (iterator.hasNext()) {
                                Uredjaj u = (Uredjaj) iterator.next();
                                System.out.println(u.id + " " + u.naziv);
                            }
                            System.out.println("--------\n");
                        } catch (Exception e) {
                            this.logger.log("Greska prilikom ucitavanja klase", "warning");
                        }

                    }

                } catch (InterruptedException ex) {
                    this.logger.log("Problem u radu sa dretvom", "warning");
                }

            }
        };

        new Thread(dretva).start();

    }

}
