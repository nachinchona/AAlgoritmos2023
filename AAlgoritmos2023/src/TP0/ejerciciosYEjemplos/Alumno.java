package TP0.ejerciciosYEjemplos;
import java.text.DecimalFormat;
public class Alumno {
    
    int idAlumno;
    double[] notasQuimica;
    double[] notasLengua;
    double[] notasMatematica;
    double[] notasBiologia;
    double[] notasSociales;
    
    public Alumno(int id){
        idAlumno = id;
    }
    
    public void setNotas(double[] notas, int materia){
        switch(materia){
            case 1: notasQuimica = notas;
            break;
            case 2: notasLengua = notas;
            break;
            case 3: notasMatematica = notas;
            break;
            case 4: notasBiologia = notas;
            break;
            case 5: notasSociales = notas;
            break;
        }
    }
    
    public double[] getNotas(int materia){
        double[] r = null;
        switch(materia){
            case 1: r = notasQuimica;
            break;
            case 2: r = notasLengua;
            break;
            case 3: r = notasMatematica;
            break;
            case 4: r = notasBiologia;
            break;
            case 5: r = notasSociales;
            break;
        }
        return r;
    }
    
    public String mostrarNotas(double[] notas){
        String r = "";
        for (int i = 0; i < notas.length; i++) {
            r = r + " "+notas[i]+" ";
        }
        return r;
    }
    public String toString(){
        String r = "Alumno "+idAlumno+"\nNotas Quimica: "+mostrarNotas(notasQuimica)+"\nNotas Lengua: ";
        r = r + mostrarNotas(notasLengua)+"\nNotas Matematica: "+mostrarNotas(notasMatematica)+"\nNotas Biologia: "+mostrarNotas(notasBiologia);
        r = r + "\nNotas Sociales: "+mostrarNotas(notasSociales)+"\n";
        return r;
    }
}
