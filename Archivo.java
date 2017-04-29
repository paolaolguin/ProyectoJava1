import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
public class Archivo{
  public static void leer_archivo(String archivo) throws FileNotFoundException, IOException {
      Recursiva recur = new Recursiva();
      Iterativa iter = new Iterativa();
      String cadena;
      File h = new File(archivo);
      FileReader f = new FileReader(h);
      BufferedReader b = new BufferedReader(f);
      String[] filas = new String[1];
      int count =  0;

      while((cadena = b.readLine())!=null) {
          if (count >= filas.length)
          {
              String[] temp = new String[filas.length * 2];
              for(int i = 0; i < filas.length; i++){
                temp[i] = filas[i];

              }
              filas = temp;
          }

          filas[count] = cadena;
          count++;
      }

      if (filas.length > count){

        String[] temp = new String[count];
        for (int i = 0; i < count; i++){
          temp[i] = filas[i];

        }
        filas = temp;
      }

      b.close();
      f.close();

      int mayor = recur.area_mayor(filas);
      System.out.println(mayor);
  }
}
