/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.factory;

import java.util.List;
import uzdiz_zadaca_2.composite.Mjesto;
import uzdiz_zadaca_2.composite.Uredjaj;

/**
 *
 * @author abenkovic
 */
public abstract class FoiFactory {
    
    public FoiFactory() {
        
    }
    
    public List<Mjesto> kreirajMjesta(String datoteka) { return null;};

    
    public List<Uredjaj> kreirajUredjaje(String type, String datoteka){ return null;};
    
    
}
