package TP0.ejerciciosYEjemplos;

import java.util.Scanner;

public class Ej23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i = 2, cantDivisores = 1;
        System.out.println("Ingrese un numero");
        n = sc.nextInt();
        int raizN = (int) Math.sqrt(n);

        //utilizando propiedades de algebra
        if (n == 1) {
            System.out.println("no es primo");
        } else {
            while (i <= raizN && cantDivisores < 2) {
                if (n % i == 0) {
                    cantDivisores++;
                }
                i++;
            }
            if (cantDivisores < 2) {
                System.out.println("el numero es primo");
            } else {
                System.out.println("no es primo");
            }
        }

        /*
        solucion vieja
        for (int j = 1; j <= n; j++) {
            int i = 2;
            cantDivisores = 1;
            while(cantDivisores <= 2 && i <= n){
                if(j % i == 0){
                    cantDivisores++;
                }
                i++;
            }
            if (cantDivisores == 2) {
                System.out.println(j);
            }
        }
         */
    }
}
