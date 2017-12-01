/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.factory;

import java.util.HashMap;
import java.util.List;
import uzdiz_zadaca_2.core.Mjesto;
import uzdiz_zadaca_2.core.Uredjaj;

/**
 *
 * @author abenkovic
 */
public abstract class FoiFactory {
    
    public FoiFactory() {
        
    }
    
    public List<Mjesto> kreirajMjesta(String datoteka) { return null;};

    
    protected Uredjaj kreirajUredjaj(String type){ return null;};
    
    
  
    
}
