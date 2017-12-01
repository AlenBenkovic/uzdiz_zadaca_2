/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.builder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import uzdiz_zadaca_2.composite.Mjesto;
import uzdiz_zadaca_2.composite.Uredjaj;
import uzdiz_zadaca_2.factory.FoiFactory;
import uzdiz_zadaca_2.factory.MjestoFactory;
import uzdiz_zadaca_2.factory.UredjajFactory;
import uzdiz_zadaca_2.logs.FoiLogger;
import static uzdiz_zadaca_2.utils.Params.params;

/**
 *
 * @author abenkovic
 */
public class ToFBuilder {
    
    public ToFBuilder(Builder builder) {
        
    }

    public static class Builder {
        private final HashMap params;  
        FoiLogger logger = FoiLogger.getInstance();
        List<Mjesto> mjesta;
        List<Uredjaj> uredjaji;
        
        public Builder(HashMap params) {
            this.params = params;   
            this.logger.init(this.params.get("-i").toString(), Integer.parseInt(this.params.get("-brl").toString()));
        }
        
        public Builder kreirajMjesta(){
            FoiFactory factory = new MjestoFactory();
            this.mjesta = factory.kreirajMjesta(this.params.get("-m").toString());
            
            return this;
        }
        
        public Builder kreirajUredjaje(){
            FoiFactory factory = new UredjajFactory();
            this.uredjaji = factory.kreirajUredjaje("senzor", this.params.get("-s").toString());
            this.uredjaji = factory.kreirajUredjaje("aktuator", this.params.get("-a").toString());
            
            return this;
        }
        
        public Builder postaviUredjaje() {
            for (Mjesto m: mjesta){
                System.out.println(m.uuid + " " + m.naziv);
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
