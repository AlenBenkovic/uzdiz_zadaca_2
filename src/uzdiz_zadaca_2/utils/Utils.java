/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.utils;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author abenkovic
 */
public class Utils {

    static HashMap params = new HashMap();

    public static boolean checkArgs(String[] args) {
        boolean status = false;

        if (args[0].equals("--help")) {

            System.out.println("zatražio help");

        } else {

            for (int i = 0; i < args.length - 1; i = i + 2) {
                checkParams(args[i], args[i + 1]);
            }
            
        }
        

        return status;
    }

    private static boolean checkParams(String flag, String value) {
        System.out.println("STIGLO: " + flag + " " + value);
        boolean status = false;
        Pattern pattern;
        Matcher matcher;
        switch (flag) {
            case "-g":
                System.out.println("provjera g");
                if (Integer.parseInt(value) >= 100 && Integer.parseInt(value) <= 65535) {
                    status = true;
                    params.put(flag, value);
                } else {
                    status = false;
                }
                break;
            case "-m":
            case "-s":
            case "-a":
                System.out.println("provjera m");
                pattern = Pattern.compile("\\w*(.txt)?");
                matcher = pattern.matcher(value);
                status = matcher.matches();
                break;
            case "-alg":
                System.out.println("provjera alg");
                break;
            case "-tcd":
            case "-bcd":
            case "-brl":
                System.out.println("provjera tcd");
                pattern = Pattern.compile("\\d*");
                matcher = pattern.matcher(value);
                status = matcher.matches();
                break;
            case "-i":
                System.out.println("provjera i");
                break;
        }
        if (status) {
            params.put(flag, value);
        }
        System.out.println(status);
        return status;
    }

}
