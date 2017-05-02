import java.util.Scanner;
public class Iterativa{
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

  public static int area_base(String[] x, int fila, int min, int max){
    /* Método que, tras hallar un triangulo blanco que mira hacia la base, ve si
    dicho triangulo tiene base blanca*/
    int area;
    area = 1;
    for (int v = 1; v <= (fila) ; v++){
      if (verificar_base(x, fila, min-2*(v-1) , max)){
        String siguiente_fila = x[fila - v].substring(min -2*v, max);
        if (siguiente_fila.equals(otra_fila(min - 2*v, max))){
          area ++;
        }
        else{
          break;
        }
      }
    }
    return area*area;
    }
  public static int area_punta(String[] x, int fila, int min, int max){
    /* Método que, tras hallar un triangulo blanco que mira hacia la punta, ve si
    dicho triangulo tiene base blanca*/
    int area;
    area = 1;
    for (int v = 1; v <= ((x.length-1) - fila) ; v++){
      if((verificar_punta(x, fila, min, max+2*(v-1)))){
        String siguiente_fila = x[fila + v].substring(min, max + 2*v);
        if (siguiente_fila.equals(otra_fila(min, max + 2*v))){
          area++;
        }
        else{
          break;
        }
      }
    }
    return area*area;
  }
  public static int area_mayor(String[] x){
    /*Método que busca la mayor área. Inicia el área como cero, de tal forma que,
    si se encuentra un area más grande, se reemplaza por esta. Va recorriendo por
    fila hasta encontrar un triangulo blanco. Dependiendo de si el índice del String
    donde se encontró el triangulo es par o impar, se manda a area punta o a area base,
    respectivamente.*/
    int max = 0; //area mayor
    for (int i = 0; i < x.length; i++){
      //i indice fila (array)
      // j indice string
      for (int j = 0; j < x[i].length(); j++){
        int maximo = j + 1;
        if( x[i].substring(j, maximo).equals("-")){
          if( j%2 == 0){
            if( max < area_punta(x, i, j, maximo)){
              max = area_punta(x, i, j, maximo);
            }
          }
        }
      }
    }
    for (int n = x.length -1; n >= 0; n--){
      for ( int k = 0; k < x[n].length(); k++){
        if( x[n].substring(k, k+1).equals("-")){
          if( k%2 == 1){
            if( max < area_base(x, n, k, k+1)){
              max = area_base(x, n, k, k+1);
            }
          }
        }
      }
    }
    return max;
  }
}
