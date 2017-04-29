import java.util.Scanner;
public class Consola{
  public static void consola(){
    Iterativa iter = new Iterativa();
    Recursiva recur = new Recursiva();
    //Recibir el Triangulo
    System.out.println("Especifique número de filas del triángulo: ");
    Scanner input2 = new Scanner(System.in);
    int n = input2.nextInt(); //numero de filas
    String[] filas = new String[n]; //arreglo de tamaño n
    Scanner input = new Scanner(System.in);
    String fila;
    boolean verificador;
    int mayor = 0;
    //Lo siguiente es para ingresar las filas por consola, una a una
    System.out.println("Ingrese las filas de a uno.");
    for( int i = 0; i < n ; i++){;
        do{
	    System.out.println("Ingrese la fila del triángulo, este debe tener "+(2*i+1)+" caracteres: ");
	    fila = input.nextLine();
	    verificador = (fila.length() == 2*i+1)? false:true;
	     }
	    while (verificador);
      filas[i] = fila;
    }

    
    //Para elegir como trabajará el programa
    System.out.println("Especifique si quiere trabajar iterativamente(1) o recursivamente(2)");
    Scanner input20 = new Scanner(System.in);
    int tipo = input20.nextInt();
    if (tipo == 1){
      mayor = iter.area_mayor(filas);
    }
    else{
      mayor = recur.area_mayor(filas);
    }
    System.out.println(mayor);
  }
}
