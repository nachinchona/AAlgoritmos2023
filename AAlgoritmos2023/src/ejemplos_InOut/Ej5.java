package ejemplos_InOut;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ej5 {

    public static void main(String[] args) {

        String nombreArchivoSalida = "C:\\Users\\nacho\\OneDrive\\Documentos\\NetBeansProjects\\RepasoAA\\src\\ejemplos_InOut\\salida.txt";

        try {
            FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

            Random random = new Random();
            Set<Integer> numeros = new HashSet();

            for (int i = 0; i < 100; i++) {
                int numRandom = random.nextInt(0, 1000);
                while (numeros.contains(numRandom)) {
                    numRandom = random.nextInt(0, 1000);
                }
                bufferEscritura.write(String.valueOf(numRandom) + "\n");
                numeros.add(numRandom);
            }

            bufferEscritura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
}
