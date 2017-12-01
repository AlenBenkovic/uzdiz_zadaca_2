/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.builder;

import java.util.HashMap;
import uzdiz_zadaca_2.composite.Aktuator;
import uzdiz_zadaca_2.composite.FoiZgrada;
import uzdiz_zadaca_2.composite.Mjesto;
import uzdiz_zadaca_2.composite.Senzor;
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
            
            for(Mjesto m:this.foiZgrada.getMjesta()){
                System.out.println(m.id + " " + m.naziv);
                    for(Aktuator a: m.getAktuatori()){
                        for(Senzor s: a.getSenzori()){
                            System.out.println(s.naziv);
                        }
                }
            }
            
            
            return this;
        }
        
        public Builder kreirajUredjaje(){
            FoiFactory factory = new UredjajFactory(this.params);
            factory.kreirajUredjaj(false, 1);
            
            for(Mjesto m: foiZgrada.getMjesta()){
                
            }
            
            return this;
        }
        
        public Builder postaviUredjaje() {
            
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
