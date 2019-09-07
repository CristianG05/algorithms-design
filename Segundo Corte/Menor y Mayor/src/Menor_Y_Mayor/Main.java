package Menor_Y_Mayor;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random ran = new Random();
        int opc = 0, n, tam;
        String mayor;
        Scanner leer = new Scanner(System.in);

        System.out.print("¿De qué tamaño desea el arreglo?: ");
        n = leer.nextInt();
        System.out.println("Ingrese la longitud de los valores del arreglo:");
        tam = leer.nextInt();
        System.out.println();
        int[] V = new int[n];
        for (int i = 0; i < V.length; i++) {
            V[i] = ran.nextInt(tam);
            System.out.println(V[i]);
        }
        System.out.println();
        while (opc != 3) {

            System.out.println("OPCIONES\n"
                    + "1.Menor\n"
                    + "2.Mayor\n"
                    + "3.Salir\n"
                    + "Elija la opción que desea");
            try {
                opc = leer.nextInt();
                switch(opc){
                    case 1: 
                        Menor men= new Menor();
                        System.out.println("El número menor es:"+men.minimo(V));
                    case 2:
                        Mayor may= new Mayor();
                        System.out.println("El número mayor es:"+may.maximo(V));
                }
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println("Debe elegir una de las opciones disponibles");

            }

        }

    }

}
