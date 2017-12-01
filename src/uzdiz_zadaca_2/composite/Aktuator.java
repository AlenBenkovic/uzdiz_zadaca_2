/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.composite;

import java.util.List;

/**
 *
 * @author abenkovic
 */
public class Aktuator extends Uredjaj implements Foi {
    
    List<Senzor> senzori;
    
    public Aktuator(String naziv, int tip, int vrsta, float min, float max, String komentar) {
        super(naziv, tip, vrsta, min, max, komentar);
    }

    @Override
    public void provjera() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
