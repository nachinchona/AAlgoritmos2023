package TP0.ejerciciosYEjemplos;
import java.util.Random;

public class Ej28 {

    
    public static void quickSort(double[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    //metodo quickSort
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high + 1) {
            int pivot = particionar(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int particionar(double[] arr, int low, int high) {
        //coloca los elementos menores al pivote a su izquierda y los mayores a su derecha
        //el primer elemento del arreglo se toma como pivot
        int limite = low + 1;
        for (int i = limite; i <= high; i++) {
            if (arr[i] < arr[low]) {
                intercambiar(arr, i, limite);
                limite++;
            }
        }
        //intercambia el pivot con el ultimo elemento menor encontrado
        intercambiar(arr, low, limite - 1);
        return limite - 1;
    }

    public static void intercambiar(double[] arr, int a, int b) {
        double temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public static void burbuja(double[] arr) {
        int length = arr.length - 1;
        double aux;
        int i = 0;
        boolean bandera = false;
        while(i < length && !bandera) {
            bandera = true;
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    aux = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = aux;
                    bandera = false;
                }
            }
            i++;
        }
    }

    public static double mediaAlumno(Alumno a) {
        double media = 0;
        int n = 0;
        double[] notasQ = a.getNotas(1);
        double[] notasL = a.getNotas(2);
        double[] notasM = a.getNotas(3);
        double[] notasB = a.getNotas(4);
        double[] notasS = a.getNotas(5);

        for (int i = 0; i < notasQ.length; i++) {
            media = media + notasQ[i];
            n = n + 1;
        }
        for (int i = 0; i < notasL.length; i++) {
            media = media + notasL[i];
            n = n + 1;
        }
        for (int i = 0; i < notasM.length; i++) {
            media = media + notasM[i];
            n = n + 1;
        }
        for (int i = 0; i < notasB.length; i++) {
            media = media + notasB[i];
            n = n + 1;
        }
        for (int i = 0; i < notasS.length; i++) {
            media = media + notasS[i];
            n = n + 1;
        }

        media = media / n;
        return media;
    }

    public static double mediaAsignatura(Alumno[] a, int materia) {
        double media = 0;
        int n = 0;

        for (int i = 0; i < a.length; i++) {
            double[] notas = a[i].getNotas(materia);
            for (int j = 0; j < 3; j++) {
                media = media + notas[j];
                n = n + 1;
            }
        }

        media = media / n;
        return media;
    }

    public static void main(String[] args) {
        Random r = new Random();
        double[] notasQ1 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasQ2 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasQ3 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasQ4 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasQ5 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};

        double[] notasL1 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasL2 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasL3 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasL4 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasL5 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};

        double[] notasM1 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasM2 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasM3 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasM4 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasM5 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};

        double[] notasB1 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasB2 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasB3 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasB4 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasB5 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};

        double[] notasS1 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasS2 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasS3 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasS4 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};
        double[] notasS5 = {r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00, r.nextInt(0, 1000)/100.00};

        Alumno a1 = new Alumno(1);
        Alumno a2 = new Alumno(2);
        Alumno a3 = new Alumno(3);
        Alumno a4 = new Alumno(4);
        Alumno a5 = new Alumno(5);

        Alumno[] alumnos = {a1, a2, a3, a4, a5};

        a1.setNotas(notasQ1, 1);
        a2.setNotas(notasQ2, 1);
        a3.setNotas(notasQ3, 1);
        a4.setNotas(notasQ4, 1);
        a5.setNotas(notasQ5, 1);

        a1.setNotas(notasL1, 2);
        a2.setNotas(notasL2, 2);
        a3.setNotas(notasL3, 2);
        a4.setNotas(notasL4, 2);
        a5.setNotas(notasL5, 2);

        a1.setNotas(notasM1, 3);
        a2.setNotas(notasM2, 3);
        a3.setNotas(notasM3, 3);
        a4.setNotas(notasM4, 3);
        a5.setNotas(notasM5, 3);

        a1.setNotas(notasB1, 4);
        a2.setNotas(notasB2, 4);
        a3.setNotas(notasB3, 4);
        a4.setNotas(notasB4, 4);
        a5.setNotas(notasB5, 4);

        a1.setNotas(notasS1, 5);
        a2.setNotas(notasS2, 5);
        a3.setNotas(notasS3, 5);
        a4.setNotas(notasS4, 5);
        a5.setNotas(notasS5, 5);

        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());
        System.out.println(a4.toString());
        System.out.println(a5.toString());

        System.out.println("Media Alumno 1: " + mediaAlumno(a1));
        System.out.println("\nMedia Quimica: " + mediaAsignatura(alumnos, 1)+"\n");
        
        double[] mediasAsignatura = {mediaAsignatura(alumnos, 1), mediaAsignatura(alumnos, 2), mediaAsignatura(alumnos, 3),
        mediaAsignatura(alumnos, 4), mediaAsignatura(alumnos, 5)};
        System.out.println("Medias de todas las asignaturas de todos los alumnos\n");
        imprimirArreglo(mediasAsignatura);
        System.out.println("Medias ordenadas");
        burbuja(mediasAsignatura);
        //quickSort(mediasAsignatura);
        imprimirArreglo(mediasAsignatura);
        
        
    }
    
    public static void imprimirArreglo(double[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
