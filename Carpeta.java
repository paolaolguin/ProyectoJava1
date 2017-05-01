import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
public class Carpeta extends Archivo{
  static File carpeta(String[] x, String path) throws IOException{
    File archivo = new File("archivo_nuevo.txt");
    int mayor = 0;
    int[] mayores = new int[x.length];
    for (int i = 0; i < x.length; i++){
        mayor = leer_archivo(x[i]);
        mayores[i] = mayor;
    }
    FileWriter fw = new FileWriter(archivo);
    PrintWriter pw = new PrintWriter(fw);
    for (int j = 0; j < mayores.length; j++){
      pw.println(mayores[j]);
    }
    pw.close();
    return archivo;
  }
}
