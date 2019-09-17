package Clases;

import java.util.Scanner;

/**
 *
 * @author Steven
 */
public class Crear {

    public static void crear() {
        Scanner sc = new Scanner(System.in);
        System.out.print("INGRESE EL TAMAÑO: ");
        int tam = sc.nextInt();
        System.out.println("");
        int casas[] = new int[tam];

        for (int i = 0; i < tam; i++) {
            casas[i] = i + 1;
        }
        Casa ca = new Casa();
        ca.busqueda(tam, casas);
    }
}
