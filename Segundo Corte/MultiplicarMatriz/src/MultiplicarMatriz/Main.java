package MultiplicarMatriz;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int fil, col, fil1, col1;
        System.out.print("Ingrese el número de filas de la matriz 1:");
        fil = leer.nextInt();
        System.out.println();
        System.out.print("Ingrese el número de columnas de la matriz 1:");
        col = leer.nextInt();
        System.out.println();
        System.out.print("Ingrese el número de filas de la matriz 2:");
        fil1 = leer.nextInt();
        System.out.println();
        System.out.print("Ingrese el número de columnas de la matriz 2:");
        col1 = leer.nextInt();
        System.out.println();
        int[][] a = new int[fil][col];
        int[][] b = new int[fil1][col1];

        //Llenar matriz
        if (fil==col1) {
            System.out.println("Primero llenaremos la matriz 1:");

            for (int x = 0; x < fil; x++) {
                for (int y = 0; y < col; y++) {
                    System.out.print("Ingrese el valor para la posición (" + x + "," + y + "):");
                    a[x][y] = leer.nextInt();
                }
            }
            System.out.println();
            System.out.println("Ahora llenaremos la matriz 2:");

            for (int x = 0; x < fil1; x++) {
                for (int y = 0; y < col1; y++) {
                    System.out.print("Ingrese el valor para la posición (" + x + "," + y + "):");
                    b[x][y] = leer.nextInt();
                }
            }
            //Impresión matriz
            System.out.println("La matriz 1 es: ");
            System.out.println();
            for (int x = 0; x < a.length; x++) {
                System.out.print("|");
                for (int y = 0; y < a[x].length; y++) {
                    System.out.print(a[x][y]);
                    if (y != a[x].length - 1) {
                        System.out.print("\t");
                    }
                }
                System.out.println("|");
            }
            System.out.println("La matriz 2 es: ");
            System.out.println();
            for (int x = 0; x < b.length; x++) {
                System.out.print("|");
                for (int y = 0; y < b[x].length; y++) {
                    System.out.print(b[x][y]);
                    if (y != b[x].length - 1) {
                        System.out.print("\t");
                    }
                }
                System.out.println("|");
            }
            //Llamado clase
            System.out.println("La matriz resultante es:");
            System.out.println();
            Multiplicar mul = new Multiplicar();
            int[][] c = mul.multiplicar(a, b);
            System.out.println(Arrays.deepToString(c));
        }else{
            System.out.println("La multiplicación no es posible.");
        }
    }

}
