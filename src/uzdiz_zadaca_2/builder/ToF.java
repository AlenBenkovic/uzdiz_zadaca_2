/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.builder;

import java.util.Collections;
import java.util.HashMap;
import uzdiz_zadaca_2.logs.FoiLogger;
import static uzdiz_zadaca_2.utils.Params.params;

/**
 *
 * @author abenkovic
 */
public class ToF {
    
    public ToF(Builder builder) {
        
    }

    public static class Builder {
        private final HashMap params;  
        FoiLogger logger = FoiLogger.getInstance();
        
        public Builder(HashMap params) {
            this.params = params;   
            this.logger.init(this.params.get("-i").toString());
        }
        
        public Builder postaviUredjaje() {
            this.logger.log("TEST", "info");

            return this;
        }

        public Builder inicijalizacija() {
            return this;

        }
        
        public ToF build() {
            return new ToF(this);
        }

    }
    
    public void radiProvjere() {

    }
    

}
