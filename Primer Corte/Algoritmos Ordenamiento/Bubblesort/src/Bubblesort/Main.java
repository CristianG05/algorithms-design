package Bubblesort;

import java.io.*;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) throws IOException {
        try {
            int n,ini, fin;
            Scanner sc=new Scanner(System.in);
            String texto;
            
            FileReader fr = new FileReader("Origen.txt");
            BufferedReader br = new BufferedReader(fr);
            texto = br.readLine();
            String[] linea = texto.split(",");
            System.out.println("Ingrese la cantidad de números que desea ordenar:");
            n=sc.nextInt();
            System.out.println("La lista ordenada es:");
            int[] lista = new int[n];
            for (int i = 0; i < n; i++) {
                lista[i] = Integer.parseInt(linea[i]);
            }
            for (int i = 0; i < n; i++) {
                System.out.println(lista[i]);
            }
            ini = (int) System.currentTimeMillis();
            Ordenamiento BUS = new Ordenamiento();
            BUS.BurbujaS(lista);
            fin = (int) System.currentTimeMillis();
        CalculaT cal = new CalculaT();
        cal.TiempoR(ini, fin);
        } catch (FileNotFoundException err) {
            System.out.println(err.getMessage());
        }
    }

}
