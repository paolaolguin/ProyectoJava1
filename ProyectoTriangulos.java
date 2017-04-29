import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class ProyectoTriangulos{
  public static void main(String[] args) throws IOException{
    Iterativa iter = new Iterativa();
    Recursiva recur = new Recursiva();
    Consola conso = new Consola();
    Archivo arch = new Archivo();
    Carpeta carp = new Carpeta();

    System.out.println("Especifique cómo ingresará las cosas: por consola(1); por el archivo adjunto(2);  por un archivo propio(3); por carpeta(4): ");
    Scanner input = new Scanner(System.in);
    Scanner input0 = new Scanner(System.in);
    Scanner input1 = new Scanner(System.in);
    int opcion = input.nextInt();
    switch(opcion){
      case 1 : conso.consola();
              break;

      case 2 : arch.leer_archivo("ejemplo.txt");
              break;

      case 3 : System.out.println("ingrese la ruta del archivo");
              String ruta = input0.nextLine();
              System.out.println("igrese el nombre del archivo");
              String nombre = input1.nextLine();
              String archivo = ruta+"/"+nombre+".txt";
              arch.leer_archivo(archivo);
              break;

      case 4 : carp.carpeta();
              break;

      default: System.out.println("haha you're so tough aren't ya? breaking the rules and stuff...");
    }
  }
}
