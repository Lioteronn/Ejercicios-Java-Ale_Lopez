package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Nochevieja {

    public static Scanner scanner = new Scanner(System.in);
    public static int[] diasMeses = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static ArrayList<Integer> resultados = new ArrayList<>();

    public static void main(String[] args) {

        introducirDatos(Integer.parseInt(scanner.nextLine()));
        escribirDatos();

    }

    public static void introducirDatos(int numeroVeces) {

        String[] datos;
        int dias;
        int meses;

        for (int i = 0; i < numeroVeces; i++) {
            datos = scanner.nextLine().split(" ");
            dias = Integer.parseInt(datos[0]);
            meses = Integer.parseInt(datos[1]);

            resultados.add(nochevieja(dias, meses));
        }

    }

    public static void escribirDatos() {
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(resultados.get(i));
        }
    }

    public static int nochevieja(int dias, int meses) {

        int diasRestantes = 0;

        for (int i = 0; i < meses - 1; i++) {
            diasRestantes += diasMeses[i];
        }

        diasRestantes += dias;

        return 365 - diasRestantes;

    }
}