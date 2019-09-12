package Bubblesort;

import java.io.PrintWriter;

public class Ordenamiento {

    public void BurbujaS(int[] lista) {
        Imprimir im = new Imprimir();
        int tmp;
        for (int i = 1; i < lista.length; i++) {
            for (int j = 0; j < lista.length - 1; j++) {
                if (lista[j] > lista[j + 1]) {
                    tmp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = tmp;
                }
            }
        }
        im.Imprimir(lista);
    }

}

