package ejemplos_InOut;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Ej3 {

    public static void main(String[] args) {

        String nombreArchivoSalida = "C:\\Users\\nacho\\OneDrive\\Documentos\\NetBeansProjects\\RepasoAA\\src\\ejemplos_InOut\\salida.txt";

        try {
            FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

            Random random = new Random();

            String numeros = "";
            
            for (int i = 0; i < 100; i++) {
                double numRandom = random.nextDouble(-100, 100);
                numeros = numeros + numRandom + "\n";
            }
            
            bufferEscritura.write(numeros);
            
            bufferEscritura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
}
