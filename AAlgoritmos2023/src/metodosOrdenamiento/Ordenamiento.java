package metodosOrdenamiento;

import java.util.Scanner;

public class Ordenamiento {

    public static void main(String[] args) {
        //zona de declaración
        Scanner sc = new Scanner(System.in);
        int length, seleccion;
        int[] arr;
        int[] respaldo;

        //entrada de datos
        System.out.println("CREACIÓN Y CARGA DEL ARREGLO");
        System.out.println("Ingrese la cantidad de elementos que desea que tenga el arreglo:");
        length = sc.nextInt();
        arr = new int[length];
        respaldo = new int[length];
        cargar(arr);
        copiar(respaldo, arr);
        mostrar(arr);

        imprimirMenu();

        System.out.println("---Ingrese lo que desea hacer:");
        seleccion = sc.nextInt();
        System.out.println("");
        while (seleccion != 6) {
            switch (seleccion) {
                case 1:
                    System.out.println("Arreglo sin ordenar:");
                    mostrar(arr);
                    mergeSort(arr);
                    System.out.println("Arreglo ordenado por mergeSort:");
                    mostrar(arr);
                    copiar(arr, respaldo);
                    break;
                case 2:
                    System.out.println("Arreglo sin ordenar:");
                    mostrar(arr);
                    quickSort(arr);
                    System.out.println("Arreglo ordenado por quickSort:");
                    mostrar(arr);
                    copiar(arr, respaldo);
                    break;
                case 3:
                    System.out.println("Arreglo sin ordenar:");
                    mostrar(arr);
                    heapSort(arr);
                    System.out.println("Arreglo ordenado por heapSort:");
                    mostrar(arr);
                    copiar(arr, respaldo);
                    break;
                case 4:
                    cargar(arr);
                    copiar(respaldo, arr);
                    mostrar(arr);
                    break;
                case 5:
                    System.out.println("Ingrese la cantidad de elementos que desea que tenga el arreglo:");
                    length = sc.nextInt();
                    arr = new int[length];
                    respaldo = new int[length];
                    cargar(arr);
                    copiar(respaldo, arr);
                    System.out.println("ARREGLO CARGADO");
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
            System.out.println("");
            System.out.println("---Ingrese lo que desea hacer:");
            seleccion = sc.nextInt();
            System.out.println("");
        }

    }

    public static void imprimirMenu() {
        System.out.println("------------------------------------------------------");
        System.out.println("Opciones:");
        System.out.println("1. Ordenar arreglo con el método mergeSort");
        System.out.println("2. Ordenar arreglo con el método quickSort");
        System.out.println("3. Ordenar arreglo con el método heapSort");
        System.out.println("4. Cargar arreglo con elementos distintos");
        System.out.println("5. Crear y cargar arreglo con otra cantidad de elementos");
        System.out.println("6. Salir");
        System.out.println("------------------------------------------------------");
    }

    //METODOS PARA ARREGLOS
    //intercambia dos elementos de un arreglo
    public static void intercambiar(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //imprime por pantalla un arreglo
    public static void mostrar(int[] arr) {
        int longitud = arr.length;
        for (int i = 0; i < longitud; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }

    public static void copiar(int[] arr, int[] arr2) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            arr[i] = arr2[i];
        }
    }

    //carga los elementos de un arreglo
    public static void cargar(int[] arr) {
        Scanner sc = new Scanner(System.in);

        int length = arr.length;
        for (int i = 0; i < length; i++) {
            System.out.println("Ingrese el elemento en la posición " + i);
            arr[i] = sc.nextInt();
        }
        System.out.println("");
        System.out.println("ARREGLO CARGADO");
    }

    //retorna el indice del elemento mas grande
    public static int retornarPosMasGrande(int[] arr, int a, int b) {
        int pos;
        if (arr[a] < arr[b]) {
            pos = b;
        } else {
            pos = a;
        }
        return pos;
    }

    //METODOS PARA MERGE SORT
    //metodo de invocacion
    public static void mergeSort(int[] arr) {
        int length = arr.length;
        int[] temp = new int[length];
        merge(arr, temp, 0, length - 1);
    }

    //metodo mergeSort
    public static void merge(int[] arr, int[] temp, int izq, int der) {
        int centro;
        if (izq < der) {
            centro = (izq + der) / 2;
            //llamado recursivo de la mitad izquierda
            merge(arr, temp, izq, centro);
            //llamado recursivo de la mitad derecha
            merge(arr, temp, centro + 1, der);
            //mezcla ambas mitades
            mezclar(arr, temp, izq, centro + 1, der);
        }
    }

    public static void mezclar(int[] a, int[] temp, int izq, int der, int fin) {
        //declaracion de variables
        int finIzq, posAux, numElementos, i = 0;
        finIzq = der - 1;
        posAux = izq;
        numElementos = fin;

        //compara el primer elemento de la primer mitad con el primer elemento de la segunda
        while (izq <= finIzq && der <= fin) {
            if (a[izq] < a[der]) {
                temp[posAux] = a[izq];
                posAux++;
                izq++;
            } else {
                temp[posAux] = a[der];
                der++;
                posAux++;
            }
        }

        //agrega los elementos restantes de la mitad izquierda (si es que quedaron algunos)
        while (izq <= finIzq) {
            temp[posAux] = a[izq];
            posAux++;
            izq++;
        }

        //agrega los elementos restantes de la mitad derecha (si es que quedaron algunos)
        while (der <= fin) {
            temp[posAux] = a[der];
            posAux++;
            der++;
        }

        //copia los elementos del arreglo temporal al arreglo original
        while (i <= numElementos) {
            a[fin] = temp[fin];
            i++;
            fin--;
        }
    }

    //METODOS PARA QUICK SORT
    //metodo de invocación
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

    //METODOS PARA HEAP SORT
    //metodo heapSort
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
}
