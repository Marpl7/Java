class Main {
  public static void main(String[] args) {

  int a = 10;
  int b = 2;
  int c = 3;
  int d = 4;
  String name = "Вася";
  int year = 1800;

  System.out.println(myCalculation(a, b, c, d));
  System.out.println(myCompare(a, b));
  myPositivNegativ(a);
  myPrintName(name);
  myYear(year);
  
  }

  public static float myCalculation(int a, int b, int c, int d){
    return (float)(a * (b + (c / d)));
  }

  public static boolean myCompare(int a, int b) {
    if ( (10 <= (a + b)) & ((a + b)<= 20)) {
      return true;
    } else {
      return false;
    }
  }

  public static void myPositivNegativ(int a){
    if (a >= 0){
      System.out.println("Positiv number");
    } else{
      System.out.println("Negativ number");
    }

  }

  public static void myPrintName(String name){
    System.out.println("Привет, " + name + "!");
  }

  public static void myYear(int year){
    if ( ((year % 100 != 0) & (year % 4 == 0)) | (year % 400 == 0) ){
      System.out.println("Високосный год");
    }  else {
      System.out.println("Не високосный год");
    }

  }
  
}
