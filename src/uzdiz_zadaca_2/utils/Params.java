/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uzdiz_zadaca_2.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author abenkovic
 */
public class Params {

    public static HashMap params = new HashMap();

    public static boolean checkArgs(String[] args) {
        boolean status = false;

        if (args[0].equals("--help")) {

            System.out.println("Opcije:\n");
            System.out.println("-g sjeme za generator slučajnog broja (u intervalu 100 - 65535).\n"
                    + " Ako nije upisana opcija, uzima se broj milisekundi u trenutnom vremenu na bazi"
                    + " njegovog broja sekundi i broja milisekundi.\n\n"
                    + "-m naziv datoteke mjesta\n\n"
                    + "-s naziv datoteke senzora\n\n"
                    + "-a naziv datoteke aktuatora\n\n"
                    + "-alg puni naziv klase algoritma provjere koja se dinamički učitava\n\n"
                    + "-tcd trajanje ciklusa dretve u sek.\nAko nije upisana opcija, uzima se slučajni broj u intervalu 1 - 17.\n\n"
                    + "-bcd broj ciklusa dretve.\nAko nije upisana opcija, uzima se slučajni broj u intervalu 1 - 23.\n\n"
                    + "-i naziv datoteke u koju se sprema izlaz programa.\nAko nije upisana opcija, "
                    + "uzima se vlastito korisničko ime kojem se dodaje trenutni podaci vremena \n\n"
                    + "-brl broj linija u spremniku za upis u datoteku za izlaz.\nAko nije upisana opcija,"
                    + " uzima se slučajni broj u intervalu 100 - 999.\n"
                    + "");
            System.exit(0);
            
        } else {

            for (int i = 0; i < args.length - 1; i = i + 2) {
                checkParams(args[i], args[i + 1]);
            }

            if (!params.containsKey("-g")) {
                // broj milisekundi od trenutnog vremena, a ne od 1.1.1970
                params.put("-g", Calendar.getInstance().get(Calendar.MILLISECOND));

            }

            if (!params.containsKey("-i")) {
                String timestamp = new SimpleDateFormat("_yyyyMMdd_HHmmss").format(new Date());
                String value = "alebenkov" + timestamp + ".txt";
                params.put("-i", value);
            }

            if (!params.containsKey("-tcd")) {
                params.put("-tcd", RandomNumber.dajSlucajniBroj(1, 17));
            }

            if (!params.containsKey("-bcd")) {
                params.put("-bcd", RandomNumber.dajSlucajniBroj(1, 23));
            }

            if (!params.containsKey("-brl")) {
                params.put("-brl", RandomNumber.dajSlucajniBroj(100, 999));
            }

            status = (params.containsKey("-m")
                    && params.containsKey("-s")
                    && params.containsKey("-a")
                    && params.containsKey("-alg"));

            System.out.println(Collections.singletonList(params));

        }

        return status;
    }

    private static boolean checkParams(String flag, String value) {
        boolean status = false;
        Pattern pattern;
        Matcher matcher;
        switch (flag) {
            case "-g":
                status = Integer.parseInt(value) >= 100 && Integer.parseInt(value) <= 65535;
                if (status) {
                    RandomNumber.setSeed(Long.getLong(value));
                }
                break;
            case "-m":
            case "-s":
            case "-a":
            case "-i":
                /*pattern = Pattern.compile("\\w*(.txt)?");
                matcher = pattern.matcher(value);
                status = matcher.matches();*/
                if(value.contains(" ")){
                    status = false;
                } else {
                    status = true;
                }
                break;
            case "-alg":
                try {
                    Class.forName(value);
                    status = true;
                } catch (ClassNotFoundException e) {
                    status = false;
                }
                break;
            case "-tcd":
            case "-bcd":
            case "-brl":
                pattern = Pattern.compile("\\d*");
                matcher = pattern.matcher(value);
                status = matcher.matches();
                break;
        }
        if (status) {
            params.put(flag, value);
        }

        return status;
    }

}
