/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.factory;

import java.util.List;
import uzdiz_zadaca_2.composite.Uredjaj;

/**
 *
 * @author abenkovic
 */
public class UredjajFactory extends FoiFactory {

    @Override
    public List<Uredjaj> kreirajUredjaje(String type, String datoteka) {

        if(type.equals("senzor")){
            //kreiraj senzor
        } else {
            //kreiraj aktuator
        }
        
        return null;
    }
    
    
}
