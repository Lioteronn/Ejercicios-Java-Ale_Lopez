import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String[]> arr = new ArrayList();
    static char[] arrayLetras = "BCDFGHJKLMNPQRSTVWXTZ".toCharArray();

    public static void main(String[] args) {

        introducirDatos();

        siguienteMatricula(arr);

    }

    private static void introducirDatos() {

        String entrada;

        while (true) {
            entrada = scanner.nextLine();

            if (entrada.isEmpty()) break;

            arr.add(entrada.split(" "));
        }

    }

    private static void siguienteMatricula(ArrayList<String[]> arr) {

        for (int i = 0; i < arr.size(); i++) {
            String[] arrMatricula = arr.get(i);

            int numMatricula = Integer.parseInt(arrMatricula[0]);
            String letrasMatricula = arrMatricula[1];

            if (numMatricula < 9999) {
                siguienteNumero(numMatricula, letrasMatricula);
            } else if (letrasMatricula.equals("ZZZ") && numMatricula == 9999) {
                System.out.println("No existe siguiente matrícula.");
            }
            else {
                letrasMatricula = String.valueOf(siguienteCaracter(letrasMatricula.toCharArray()));
                System.out.println("0000 "+ letrasMatricula);
            }
        }

    }

    private static void siguienteNumero(int numMatricula, String letrasMatricula) {

        numMatricula += 1;

        for (int i = String.valueOf(numMatricula).length(); i < 4; i++) {
            System.out.print("0");
        }

        System.out.print(numMatricula + " " + letrasMatricula + "\n");

    }

    private static char[] siguienteCaracter(char[] letrasMatricula) {

        for (int i = letrasMatricula.length - 1; i >= 0; i--) {

            if (i != 0 && letrasMatricula[i] == 'Z') {
                letrasMatricula[i] = 'B';
            } else if (i == 0 && letrasMatricula[i] == 'Z') {
                return letrasMatricula;
            } else {
                letrasMatricula[i] = siguienteLetra(letrasMatricula[i]);
                return letrasMatricula;
            }

        }

        return letrasMatricula;

    }

    private static char siguienteLetra(char letra) {

        for (int i = 0; i < arrayLetras.length; i++) {
            if (arrayLetras[i] == letra) return arrayLetras[i + 1];
        }

        return '-';

    }

}
