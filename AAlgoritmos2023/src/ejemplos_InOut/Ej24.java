package ejemplos_InOut;
import java.util.Scanner;
import java.util.Random;

public class Ej24 {

    public static int compararNumeros(int numeroUsuario, int numeroAdivinar) {
        int n;
        if (numeroUsuario < numeroAdivinar) {
            n = -1;
        } else if (numeroUsuario > numeroAdivinar) {
            n = 1;
        } else {
            n = 0;
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numAleatorio, min, max, amplitud, entrada;
        Random random = new Random();
        min = 50;
        max = 100;
        amplitud = max - min + 1;
        numAleatorio = random.nextInt(amplitud) + min;
        System.out.println("ADIVINA EL NÚMERO QUE ESTA ENTRE "+min+" y "+max+":");
        do {
            System.out.println("ELIGE UN NUMERO:");
            entrada = sc.nextInt();
            switch (compararNumeros(entrada, numAleatorio)) {
                case -1: System.out.println("El número es mayor, intenta con un número más grande.");break;
                case 1: System.out.println("El número es menor, intenta con un número más pequeño.");break;
                case 0: System.out.println("¡FELICITACIONES HAS ENCONTRADO EL NÚMERO!");
            }
        } while (numAleatorio != entrada);
        System.out.println("FIN DEL JUEGO, GRACIAS POR JUGAR!");
    }    
}
