/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpParameters.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validaciones {

    public List<String> validarCaracteres(List<String> lista) {

        String regex = "^[a-zA-Z0-9.@_-~#]+$";
        List<String> erroneos = new ArrayList<>();

        try {

            Pattern pattern = Pattern.compile(regex);
            for (String name : lista) {
                if (!name.isEmpty()) {
                    Matcher matcher = pattern.matcher(name);

                    if (matcher.matches() == false) {
                        erroneos.add(name);
                    }
                }

            }

        } catch (Exception e) {
            System.out.println("validarCaracteresError:" + e);
        }

        return erroneos;
    }

    public List<String> validarNumeros(List<String> lista) {
        String regex = "^[0-9]+$";
        List<String> erroneos = new ArrayList<>();
        try {
            Pattern pattern = Pattern.compile(regex);

            for (String name : lista) {
                String[] parts = name.split(":", -1);
                String part2 = parts[1];

                if (!part2.isEmpty()) {
                    Matcher matcher = pattern.matcher(part2);
                    if (matcher.matches() == false) {
                        erroneos.add(name);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("validarNumerosError:" + e);
        }

        return erroneos;
    }

    public List<String> validarLongitudes(List<String> lista) {
        List<String> erroneos = new ArrayList<>();
        try {
            for (String name : lista) {
                String[] parts = name.split(":", -1);
                String part1 = parts[0];
                String part2 = parts[1];

                if (part1.equals("msisdn") && !part2.isEmpty()) {
                    if (part2.startsWith("0")) {
                        erroneos.add(part1 + ": el valor inicial no puede ser 0");
                    } else if (part2.length()!=10) {
                        erroneos.add(part1 + ": el valor debe contener 10 dígitos");
                    }
                } else if (part1.equals("imsi") && !part2.isEmpty()) {
                    if (part2.length() > 15) {
                        erroneos.add(part1 + ": el valor no puede ser mayor a 15 dígitos");
                    }
                } else if (part1.equals("iccid") && !part2.isEmpty()) {
                    if (part2.length() > 19) {
                        erroneos.add(part1 + ": el valor no puede ser mayor a 19 dígitos");
                    }
                } else if (part1.equals("imei") && !part2.isEmpty()) {
                    if (part2.length() > 15) {
                        erroneos.add(part1 + ": el valor no puede ser mayor a 15 dígitos");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("validarLongitudes:" + e);
        }

        return erroneos;
    }

}
