public class Algoritmo{
  /*Clase mayor de los algoritmos, contiene métodos que son
  comunes a ambos*/

  public static boolean verificar_base(String[] x, int fila, int min, int max){
    /*Método que verifica si se puede agrandar un triangulo ya hecho (mira hacia la base).
    No ve que la base esté compuesta por sólo blancos, sólo ve que no se salga del triangulo
    original*/
    if (fila - 1 < 0){
      return false;
    }
    else if(min - 2 < 0 || max > x[fila-1].length()){
      return false;
    }
    else{
      return true;
    }
  }
  public static boolean verificar_punta(String[] x, int fila, int min, int max){
    if (fila + 1 == x.length){
      /*Método que verifica si se puede agrandar un triangulo ya hecho (mira hacia la punta).*/
      return false;
    }
    else{
      return true;
      }
    }
  public static String otra_fila(int min, int max){
    /*Método que forma un string compuesto de guiones del largo de la siguiente
    fila del triangulo blanco que tenemos considerar */
    String fila = "";
    for( int i = 0; i < max - min; i++ ){
      fila = fila+"-";
    }
    return fila;
  }
}
