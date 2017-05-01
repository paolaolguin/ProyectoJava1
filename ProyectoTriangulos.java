import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
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
    Scanner input2 = new Scanner(System.in);
    Scanner input3 = new Scanner(System.in);
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
              int area = arch.leer_archivo(archivo);
              System.out.println(area);
              break;

      case 4 : System.out.println("ingrese la ruta de la carpeta");
              String path = input2.nextLine();
              System.out.println("ingrese el nombre de la carpeta");
              String nombrecarpeta = input3.nextLine();
              String archivos;
              nombrecarpeta = nombrecarpeta + "/";
              path = path + "/" + nombrecarpeta;
              System.out.println(path);
              File carpeta = new File(path);
              File[] lista_archivos = carpeta.listFiles();
              String[] lista_nombres = new String[lista_archivos.length];
              //Lista que guarda todos los nombres de los archivos (String)
              for (int i = 0; i < lista_archivos.length; i++){

                if (lista_archivos[i].isFile()){
                  lista_nombres[i] = lista_archivos[i].getName();
                }
              }
              //Se modifica para tener la ruta completa de cada archivo
              for (int j = 0; j < lista_nombres.length; j++){
                String nombrearchivo = lista_nombres[j];
                lista_nombres[j] = path + nombrearchivo;
              }
              File archivo_nuevo = Carpeta.carpeta(lista_nombres, path);
              System.out.println("Revise su carpeta por un archivo llamado archivo_nuevo");
              break;

      default: System.out.println("haha you're so tough aren't ya? breaking the rules and stuff...");
    }
  }
}
