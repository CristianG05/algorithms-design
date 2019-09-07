package Menor_Y_Mayor;

public class Mayor {

    public static int Maximo(int V[], int pos) {
        int res;
        if (pos == V.length - 1) // caso base: pos indica el último elemento de t
        // en este caso este será el máximo
        {
            res = V[pos];
        } else {
            int k;
            k = Maximo(V, pos + 1); // k será el mayor desde la posición pos+1 hasta el último elemento
            if (V[pos] > k) // si t[pos] es mayor que k
            {
                res = V[pos]; //t[pos] es el máximo
            } else {
                res = k; // en caso contrario será k el máximo
            }
        }
        return (res);
    }

    /**
     * el usuario utilizará esta función por comodidad recibe un array de
     * valores enteros
     */
    public static int maximo(int V[]) {
        return (Maximo(V, 0));
    }
}
