package ejemplos_InOut;

import java.util.Random;
import static metodosOrdenamiento.Ordenamiento.intercambiar;
import static metodosOrdenamiento.Ordenamiento.retornarPosMasGrande;

public class Ej29 {

    public static void mostrar(int[] arr) {
        int longitud = arr.length;
        for (int i = 0; i < longitud; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }
    
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    //metodo quickSort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high + 1) {
            int pivot = particionar(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    public static int particionar(int[] arr, int low, int high) {
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
    
    public static void heapSort(int[] arr) {
        int n = arr.length - 1;
        armarHeapMax(arr, n);
        while (n > 0) {
            //se elimina la raiz, intercambiandola con la hoja de mas a la derecha
            intercambiar(arr, 0, n);
            n--;
            //se reposiciona la nueva raiz para conservar la propiedad de heap maximo, sin tener en cuenta los elementos eliminados
            siftDown(arr, 0, n);
        }
    }

    //metodo para convertir el arreglo en un heap maximo
    public static void armarHeapMax(int[] arr, int n) {
        for (int i = 0; i <= n; i++) {
            siftUp(arr, i);
        }
    }

    //inserta el elemento considerando si es mas grande que su nodo padre o no
    public static void siftUp(int[] arr, int i) {
        int padre;
        if (i != 0 && i % 2 == 0) {
            padre = i / 2 - 1;
        } else {
            padre = i / 2;
        }
        if (arr[i] > arr[padre]) {
            intercambiar(arr, padre, i);
            i = padre;
            siftUp(arr, i);
        }
    }

    //toma al hijo mas grande, lo compara con su padre y lo inserta donde corresponde
    public static void siftDown(int[] arr, int i, int length) {
        int izq = 2 * i + 1;
        int der = 2 * i + 2;
        int largest;

        if (izq <= length) {
            if (der <= length) {
                largest = retornarPosMasGrande(arr, izq, der);
            } else {
                largest = izq;
            }
            if (arr[i] < arr[largest]) {
                intercambiar(arr, i, largest);
                siftDown(arr, largest, length);
            }
        }
    }
    
    public static void main(String[] args) {
        Random r = new Random();
        int[] A = new int[100], B = new int[60], C = new int[160];
        
        for (int i = 0; i < 100; i++) {
            A[i] = r.nextInt(0,100);
        }
        
        for (int i = 0; i < 60; i++) {
            B[i] = r.nextInt(0,100);
        }
        
        quickSort(A);
        heapSort(B);
        
        System.arraycopy(A, 0, C, 0, 100);
        
        System.arraycopy(B, 0, C, 100, 60);
        
        mostrar(C);
        System.out.println(C.length);
    }
}
