package Menor_Y_Mayor;

public class Menor {

    public static int Minimo(int V[], int pos) {
        int res;
        if (pos == V.length - 1) // caso base: pos indica el último elemento de t
        // en este caso este será el minimo
        {
            res = V[pos];
        } else {
            int k;
            k = Minimo(V, pos + 1); // k será el menor desde la posición pos+1 hasta el último elemento
            if (V[pos] > k) // si t[pos] es mayor que k
            {
                res = k; //t[pos] es el máximo
            } else {
                res = V[pos] ; // en caso contrario será k el minimo
            }
        }
        return (res);
    }

    public static int minimo(int V[]) {
        return (Minimo(V, 0));
    }
}


