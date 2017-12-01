/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.factory;

import uzdiz_zadaca_2.core.Uredjaj;

/**
 *
 * @author abenkovic
 */
public class UredjajFactory extends FoiFactory {

    @Override
    protected Uredjaj kreirajUredjaj(String type) {
        if(type.equals("senzor")){
            //kreiraj senzor
        } else {
            //kreiraj aktuator
        }
        
        return null;
    }
    
    
}
