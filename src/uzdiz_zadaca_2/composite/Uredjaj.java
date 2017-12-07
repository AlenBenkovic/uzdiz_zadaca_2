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
public abstract class Uredjaj implements Foi {

    public String naziv;
    public int tip;
    public int vrsta;
    public float min;
    public float max;
    public String komentar;
    public float vrijednost;
    public int id;

    public boolean onemogucen = false;
    public int neuspjesneProvjere = 0;

    FoiLogger logger = FoiLogger.getInstance();

    public Uredjaj(String naziv, int tip, int vrsta, float min, float max, String komentar) {
        this.naziv = naziv;
        this.tip = tip;
        this.vrsta = vrsta;
        this.min = min;
        this.max = max;
        this.komentar = komentar;
        this.vrijednost = this.kreirajVrijednost();
        this.id = RandomNumber.dajSlucajniBroj(1, 1000);
    }

    @Override
    public boolean provjera() {
        int status = this.status();
        this.vrijednost = this.kreirajVrijednost();
        if (status < 1) {
            this.neuspjesneProvjere++;
            if (this.neuspjesneProvjere > 2) {
                this.onemogucen = true;
            }
        }

        this.logger.log("\n-----------\nUredjaj: " + this.id + " " + this.naziv
                + "\nStatus: " + status + " (neuspjesne provjere: " + this.neuspjesneProvjere + ")"
                + "\nVrijednost: " + this.getVrijednost(), status > 0 ? "info" : "warning");

        return !this.onemogucen;

    }

    @Override
    public boolean inicijalizacija() {
        return RandomNumber.dajSlucajniBroj(0, 100) < 90;
    }

    public abstract void pridruzenostUredjaja();

    public int status() {
        return RandomNumber.dajSlucajniBroj(0, 100) < 90 ? 1 : 0;
    }

    public abstract Uredjaj zamjena();

    public float kreirajVrijednost() {
        switch (this.vrsta) {
            case 0:
            case 1:
            case 2:
                return RandomNumber.dajSlucajniBroj(this.min, this.max);
            case 3:
                return RandomNumber.dajSlucajniBroj((int)this.min, (int)this.max);
        }
        return 0;

    }

    public String getVrijednost() {
        switch (this.vrsta) {
            case 0:
                return String.valueOf((int) this.vrijednost);
            case 1:
                return String.format("%.1f", this.vrijednost);
            case 2:
                return String.format("%.5f", this.vrijednost);
            case 3:
                return (int) this.vrijednost > 0 ? "da" : "ne";
        }
        return "nema";
    }

}
