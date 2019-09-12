package Bubblesort;

import java.io.PrintWriter;

public class Imprimir {

    public void Imprimir(int[] lista) {
        try {
            PrintWriter pw = new PrintWriter("Lista.txt");
            for (int j = 0; j < lista.length; j++) {
                pw.println(lista[j]);
            }
            pw.close();
        } catch (Exception err) {
            System.out.println("Ha ocurrido un error");
        }
    }
}