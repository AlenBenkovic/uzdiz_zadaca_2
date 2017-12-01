/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.core;

import java.util.ArrayList;
import java.util.HashMap;
import uzdiz_zadaca_2.utils.RandomNumber;

/**
 *
 * @author abenkovic
 */
public class Mjesto {
    public String naziv;
    public int tip;
    public int brojSenzora;
    public int brojAktuatora;
    public int uuid;

    public Mjesto(String naziv, int tip, int brojSenzora, int brojAktuatora) {
        this.naziv = naziv;
        this.tip = tip;
        this.brojSenzora = brojSenzora;
        this.brojAktuatora = brojAktuatora;
        this.uuid = RandomNumber.dajSlucajniBroj(1, 1000);
    }
    
}
