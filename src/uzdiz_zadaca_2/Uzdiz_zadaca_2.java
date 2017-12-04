/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2;

import uzdiz_zadaca_2.builder.ToFBuilder;
import uzdiz_zadaca_2.utils.Params;

/**
 *
 * @author abenkovic
 */
public class Uzdiz_zadaca_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (Params.checkArgs(args)) {
            ToFBuilder tof = new ToFBuilder.Builder(Params.params)
                    .kreirajMjesta()
                    .postaviUredjaje()
                    .inicijalizacija()
                    .opremanjeMjesta()
                    .build();
            
            tof.radiProvjere();
            
        } else {
            System.out.println("Parametri nisu ispravni!");
            System.exit(0);
        }
    }

}
