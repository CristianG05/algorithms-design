package Clases;

public class Casa {

    public void busqueda(int tam, int[] casas) {
        int izq = 0, der = 0, piv = 0, j = (piv + 1), b = piv, a = 0;
        while (piv < tam) {

            for (int x = 0; x < tam; x++) {
                if (x == piv) {
                    System.out.print("[" + casas[x] + "] ");
                } else {
                    System.out.print(casas[x] + " ");
                }
            }
            System.out.println();
            for (int i = piv - 1; i >= 0; i--) {

                izq = izq + casas[i];

            }
            System.out.println("Suma izquierda:" + izq);
            System.out.println();

            for (int h = piv + 1; h < tam; h++) {
                
                if (izq == der && der!=0) {
                    System.out.println("La condición se cumple en la casa:" + casas[piv]);
                    break;
                } else if (izq > der) {
                    der = der + casas[h];

                } else if (izq < der) {
                    break;
                }
            }
            System.out.println("Suma derecha:" + der);
            System.out.println();
            b++;
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            izq = 0;
            der = 0;
            piv++;
        }

    }
}
