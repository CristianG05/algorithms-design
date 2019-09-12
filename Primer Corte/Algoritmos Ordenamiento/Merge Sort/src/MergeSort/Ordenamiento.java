
package MergeSort;


public class Ordenamiento {
     public void mergeSort(int[] array) {
         
        if (array.length > 1) {

            int[] izquierda = Mitadizquierda(array);
            int[] derecha = Mitadderecha(array);
            

            mergeSort(izquierda);
            mergeSort(derecha);
            

            merge(array,izquierda, derecha);
            
        }
    }
    

    public int[] Mitadizquierda(int[] array) {
        int tamaño1 = array.length / 2;
        int[] izquierda = new int[tamaño1];
        for (int i = 0; i < tamaño1; i++) {
            izquierda[i] = array[i];
        }
        return izquierda;
    }
    

    public int[] Mitadderecha(int[] array) {
        int tamaño1 = array.length / 2;
        int tamaño2 = array.length - tamaño1;
        int[] right = new int[tamaño2];
        for (int i = 0; i < tamaño2; i++) {
            right[i] = array[i + tamaño1];
        }
        return right;
    }
    

    public void merge(int[] result, int[] izquierda, int[] derecha) {
        Imprimir im = new Imprimir();
        int i1 = 0;   
        int i2 = 0;  
        
        for (int i = 0; i < result.length; i++) {
            if (i2 >= derecha.length || (i1 < izquierda.length && 
                    izquierda[i1] <= derecha[i2])) {
                result[i] = izquierda[i1];   
                i1++;
            } else {
                result[i] = derecha[i2];  
                i2++;
            }
        }
        im.Imprimir(result);
    }
}
