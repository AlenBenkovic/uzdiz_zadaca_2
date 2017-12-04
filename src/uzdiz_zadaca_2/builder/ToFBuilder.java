/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.builder;

import java.util.HashMap;
import uzdiz_zadaca_2.composite.FoiZgrada;
import uzdiz_zadaca_2.composite.Mjesto;
import uzdiz_zadaca_2.factory.FoiFactory;
import uzdiz_zadaca_2.factory.MjestoFactory;
import uzdiz_zadaca_2.factory.UredjajFactory;
import uzdiz_zadaca_2.logs.FoiLogger;

/**
 *
 * @author abenkovic
 */
public class ToFBuilder {
    
    public ToFBuilder(Builder builder) {
        
    }

    public static class Builder {
        private final HashMap params;  
        private final FoiLogger logger = FoiLogger.getInstance();
        private final FoiZgrada foiZgrada = new FoiZgrada();
        
        public Builder(HashMap params) {
            this.params = params;   
            this.logger.init(this.params.get("-i").toString(), Integer.parseInt(this.params.get("-brl").toString()));
        }
        
        public Builder kreirajMjesta(){
            FoiFactory factory = new MjestoFactory();
            
            factory.kreirajMjesta(this.params.get("-m").toString()).forEach((m) -> {
                this.foiZgrada.add(m);
            });     
            
            return this;
        }
        
        public Builder postaviUredjaje() {
             FoiFactory factory = new UredjajFactory(this.params);
            for(Mjesto m : this.foiZgrada.getMjesta()){
                 String poruka = "\n-------------------------------------------------------------"
                    + "\n\tPostavljam uredjaje za " + m.naziv
                    + "\n-------------------------------------------------------------\n";
                this.logger.log(poruka, "info");
                
                for(int i=0; i<= m.brojSenzora; i++){
                    m.addUredjaj(factory.kreirajUredjaj(true, m.tip));
                }
                
                for(int i=0; i<= m.brojAktuatora; i++){
                    m.addUredjaj(factory.kreirajUredjaj(false, m.tip));
                }
            }
            
            return this;
        }

        public Builder inicijalizacija() {
            return this;

        }
        
        public ToFBuilder build() {
            return new ToFBuilder(this);
        }

    }
    
    public void radiProvjere() {

    }
    

}
