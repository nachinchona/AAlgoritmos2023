package TP0.ejerciciosYEjemplos;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Ej4 {

    public static void main(String[] args) {

        String nombreArchivoSalida = "C:\\Users\\nacho\\OneDrive\\Documentos\\NetBeansProjects\\AAlgoritmos2023\\AAlgoritmos2023\\src\\TP0\\ejerciciosYEjemplos\\salida.txt";
        
        try {
            FileWriter escritorArchivo = new FileWriter(nombreArchivoSalida);
            BufferedWriter bufferEscritura = new BufferedWriter(escritorArchivo);
            
            String cadenas = "";
            
            for (int i = 0; i < 100; i++) {
                cadenas = cadenas + generarCadena()+"\n";
            }
            
            bufferEscritura.write(cadenas);
            
            bufferEscritura.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage() + "\nSignifica que el archivo del "
                    + "que queriamos leer no existe.");
        } catch (IOException ex) {
            System.err.println("Error leyendo o escribiendo en algun archivo.");
        }
    }
    
    public static String generarCadena(){
        Random random = new Random();
        String caracteresPosibles = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int limiteSuperior = caracteresPosibles.length();
        String cadena = "";
        for (int i = 0; i < 10; i++) {
            cadena = cadena + caracteresPosibles.charAt(random.nextInt(0, limiteSuperior));
        }
        return cadena;
    }
}
