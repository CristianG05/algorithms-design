package QuickSort;

public class Ordenamiento {

    public void Quicksort(int arr[], int p, int r) { // ordenamiento del arreglo
        Imprimir im = new Imprimir();
        if (p < r) {
            int q = Particion(arr, p, r);
            Quicksort(arr, p, q - 1);
            Quicksort(arr, q + 1, r);
            im.Imprimir(arr);
        }
    }

    public int Particion(int arr[], int p, int r) {

        int x = arr[r];
        int i = p - 1, t;

        for (int j = p; j < r; j++) {
            if (arr[j] <= x) {
                i++;
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        t = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = t;

        return i + 1;

    }

}
