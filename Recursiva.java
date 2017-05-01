public class Recursiva{
  private static String[] left_triangle(String[] triangle){
    int new_length = triangle.length - 1;
    String txt;
    String[] new_triangle = new String[new_length];
    for(int i = 0; i < new_length; i++){
      txt = triangle[i+1].substring(0,triangle[i+1].length()-2);
      new_triangle[i] = txt;
    }
    return new_triangle;
  }
  private static String[] right_triangle(String[] triangle){
    int new_length = triangle.length-1;
    String txt;
    String[] new_triangle = new String[new_length];
    for(int i = 0; i < new_length; i++){
      txt = triangle[i+1].substring(2,triangle[i+1].length());
      new_triangle[i] = txt;
    }
    return new_triangle;
  }
  private static String builder(int length_of_triangle){
    String txt = "";
    for(int i = 0; i < length_of_triangle; i++){
      txt = txt +"-";
    }
    return txt;
  }
  private static int area_topdown(String[] triangle){
    if(triangle.length == 1){
      int length = triangle[0].length();
      if(triangle[0].equals(builder(length))){
        int area = (length-1)/2+1;
        return area*area;
      }
      else{
        if(triangle[0].equals("#")){
          return 0;
        }
        else{
          int area = (length-3)/2+1;
          return (area)*(area);
        }
      }
    }
    else{
      int new_length = triangle.length-1;
      int length = triangle[0].length();
      if(triangle[0].equals(builder(triangle[0].length()))){
        String[] new_triangle = new String[triangle.length-1];
        for(int i = 0; i < new_length; i++){
          new_triangle[i] = triangle[i+1];
        }
        return area_topdown(new_triangle);
      }
      else{
        if(triangle[0].equals("#")){
          return 0;
        }
        else{
          int area = (length-3)/2+1;
          return area*area;
        }
      }
    }
  }
  public static int biggus_areus(String[] triangle){
    if(triangle.length == 1){
      if(triangle[0].equals("-")){
        return 1;
      }
      else{
        return 0;
      }
    }
    else{
      if((triangle.length*triangle.length) == (area_topdown(triangle))){
        return triangle.length*triangle.length;
      }
      else{
        String[] triangle1 = left_triangle(triangle);
        int area1 = biggus_areus(triangle1);
        String[] triangle2 = right_triangle(triangle);
        int area2 = biggus_areus(triangle2);
        int area3 = area_topdown(triangle);
        if(area1 <= area2 && area2 <= area3 || area2 <= area1 && area1 <= area3){
          return area3;
        }
        else if(area1 <= area3 && area3 <= area2 || area3 <= area1 && area1 <= area2){
          return area2;
        }
        else{
          return area1;
        }
      }
    }
  }
}
