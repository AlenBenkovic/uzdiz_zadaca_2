/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.composite;

import uzdiz_zadaca_2.logs.FoiLogger;
import uzdiz_zadaca_2.utils.RandomNumber;

/**
 *
 * @author abenkovic
 */
public abstract class Uredjaj {
    
    public String naziv;
    public int tip;
    public int vrsta;
    public float min;
    public float max;
    public String komentar;
    public float vrijednost;

    public boolean onemogucen = false;
    public int neuspjesneProvjere = 0;

    FoiLogger logs = FoiLogger.getInstance();

    public Uredjaj(String naziv, int tip, int vrsta, float min, float max, String komentar) {
        this.naziv = naziv;
        this.tip = tip;
        this.vrsta = vrsta;
        this.min = min;
        this.max = max;
        this.komentar = komentar;
        this.vrijednost = RandomNumber.dajSlucajniBroj(min, max);
    }
    
}
