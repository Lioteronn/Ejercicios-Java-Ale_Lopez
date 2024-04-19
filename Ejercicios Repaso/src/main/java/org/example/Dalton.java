package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Dalton {

    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<String[]> alturas = new ArrayList<>();

    public static void main(String[] args) {
        introducirDatos();
        comprobarDalton();
    }

    public static void introducirDatos() {
        String numPersonas;
        String[] alturasPersonas;

        while (true) {
            numPersonas = scanner.nextLine();

            if (numPersonas.equals("0")) break;

            try {
                int test = Integer.parseInt(numPersonas);
            } catch (Exception e) {
                System.out.println("Número de personas inválido.");
                continue;
            }

            alturasPersonas = scanner.nextLine().split(" ");

            if (alturasPersonas.length != Integer.parseInt(numPersonas)) {
                System.out.println("Has introducido más o menos personas de las indicadas.");
                continue;
            }

            alturas.add(alturasPersonas);
        }
    }

    public static void comprobarDalton() {
        for (int i = 0; i < alturas.size(); i++) {
            if (comprobarRepetidos(alturas.get(i)) && (comprobarAscendente(alturas.get(i)) || comprobarDescendente(alturas.get(i)))) {
                System.out.println("DALTON");
            } else {
                System.out.println("DESCONOCIDOS");
            }
        }
    }

    public static boolean comprobarRepetidos(String[] arrayAlturas) {
        for (int i = 0; i < arrayAlturas.length; i++) {
            for (int j = 0; j < arrayAlturas.length; j++) {
                if (j != i && arrayAlturas[i].equals(arrayAlturas[j])) return false;
            }
        }

        return true;
    }

    public static boolean comprobarAscendente(String[] arrayAlturas) {
        for (int i = 0; i < arrayAlturas.length; i++) {
            if (i + 1 == arrayAlturas.length) break;

            if (!(Integer.parseInt(arrayAlturas[i]) > Integer.parseInt(arrayAlturas[i + 1]))) {
                return false;
            }
        }

        return true;
    }

    public static boolean comprobarDescendente(String[] arrayAlturas) {
        for (int i = 0; i < arrayAlturas.length; i++) {
            if (i + 1 == arrayAlturas.length) break;

            if (!(Integer.parseInt(arrayAlturas[i]) < Integer.parseInt(arrayAlturas[i + 1]))) {
                return false;
            }
        }

        return true;
    }

}
