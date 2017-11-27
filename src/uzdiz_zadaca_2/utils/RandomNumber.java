/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.utils;

import java.util.Random;

/**
 *
 * @author abenkovic
 */
public class RandomNumber {

    public static int dajSlucajniBroj(int odBroja, int doBroja) {
        Random rand = new Random();
        return rand.nextInt((doBroja - odBroja) + 1) + odBroja;
    }

    public static float dajSlucajniBroj(float odBroja, float doBroja) {
        Random rand = new Random();
        return odBroja + rand.nextFloat() * (doBroja - odBroja);   
    }

}
