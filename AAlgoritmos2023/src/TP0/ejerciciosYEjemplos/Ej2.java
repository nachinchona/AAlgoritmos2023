package TP0.ejerciciosYEjemplos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ej2 {

    public static void main(String[] args) {

        String nombreArchivoEntrada = "C:\\Users\\nacho\\OneDrive\\Documentos\\NetBeansProjects\\AAlgoritmos2023\\AAlgoritmos2023\\src\\TP0\\ejerciciosYEjemplos\\entrada.txt";
        String nombreArchivoSalida = "C:\\Users\\nacho\\OneDrive\\Documentos\\NetBeansProjects\\AAlgoritmos2023\\AAlgoritmos2023\\src\\TP0\\ejerciciosYEjemplos\\salida.txt";

        String linea = null;

        try {
            FileReader lectorArchivo = new FileReader(nombreArchivoEntrada);
            FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);
            BufferedReader bufferLectura = new BufferedReader(lectorArchivo);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);

            do {
                linea = bufferLectura.readLine();
                if (linea != null) {
                    bufferEscritura.write(linea + "\n");
                    bufferLectura.readLine();
                }
            } while (linea != null);

            /*
            SOLUCION 2 UTILIZANDO CONTADOR
            int i = 1;
            while ((linea = bufferLectura.readLine()) != null) {
                if (i % 2 != 0) {
                    bufferEscritura.write(linea + "\n");
                }
                i++;
            }
             */
            
            bufferLectura.close();
            bufferEscritura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
}
