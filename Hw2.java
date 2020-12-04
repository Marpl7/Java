import java.util.Arrays;
import java.lang.Math;
class Main {
  public static void main(String[] args) {

    int[] arr = {0, 1, 1, 1, 0, 0};
    int[] arr1 = new int[8];
    int[] arr2 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    int[] arr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1, 23, 0};
    int[][] arr4 = new int[4][4];
    int[] arr5 = {10, 1, 9, 5, 25};
    int[] arr6 = {1, 2, 3, 4, 5};

    System.out.println(Arrays.toString(replaceArray(arr)));
    System.out.println(Arrays.toString(fillArray(arr1)));
    System.out.println(Arrays.toString(multiplyArray(arr2)));
    System.out.println(Arrays.toString(findMinMax(arr3)));
    System.out.println(Arrays.deepToString(fillOneArray(arr4)));
    System.out.println(checkBalance(arr5));
    System.out.println(Arrays.toString(mooveArray(arr6, 2)));
  
  }
    
    // 1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;

    public static int[] replaceArray(int[] inputArray) {

      for (int i = 0; i < inputArray.length; i++) {
        if (inputArray[i] == 1){
          inputArray[i] = 0;
        } else {
        inputArray[i] = 1;
        }
      // System.out.print(inputArray[i] + " ");
      }
      return inputArray;
    }

// 2 Задать пустой целочисленный массив размером 8. Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;

    public static int[] fillArray(int[] inputArray) {
      inputArray[0] = 1;
      for(int i=1; i < inputArray.length; i++) {
        inputArray[i] = inputArray[i-1] + 3;
        // System.out.print(inputArray[i] + " ");
      }
      return inputArray;
    }

    // 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод, принимающий на вход массив и умножающий числа меньше 6 на 2;


    public static int[] multiplyArray(int[] inputArray) {
      
      for(int i=0; i < inputArray.length; i++) {
        if (inputArray[i] < 6 ){
          inputArray[i] *= 2;
        } else {
        continue;
        }
      }
      return inputArray;
    }

    // 4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;

    public static int[] findMinMax(int[] inputArray) {
      int max = inputArray[0];
      int min = inputArray[0];
      for(int i=0; i < inputArray.length; i++) {
        if (inputArray[i] < min ){
          min = inputArray[i];
        } else if (inputArray[i] > max){
          max = inputArray[i];
        }else{
          continue;
        }
      }
      return new int[] {min, max};
    }

    // 5 * Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональныеэлементы единицами, используя цикл(ы);
      
    public static int[][] fillOneArray(int[][] inputArray) {
      
      for(int i=0; i < inputArray.length; i++) {
        for(int j=0; j < inputArray.length; j++){
          if (i ==j){
          inputArray[i][j] = 1;
          }else{
           inputArray[i][j] = 0; 
          }
        }
        
        
      }
      return inputArray;
    }


    // 6 ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры:
// checkBalance([1, 1, 1, || 2, 1]) → true,
// checkBalance ([2, 1, 1, 2, 1]) → false,
// checkBalance ([10, || 1, 2, 3, 4]) → true.
// Абстрактная граница показана символами ||, эти символы в массив не входят.


     public static boolean checkBalance(int[] inputArray) {
      int sum_left = 0;
      int sum_right = 0;
      boolean res = false;

      for(int i=0; i < (inputArray.length -1); i++) {
        sum_left += inputArray[i];

        for(int j = (i + 1); j < inputArray.length; j++ ){
          sum_right += inputArray[j];
        }
        // System.out.println(i + " " + sum_left + " " + sum_right);
        if (sum_left == sum_right ){
          res = true;
          break;
        } else {
            sum_right = 0;
            continue;
        }
      }
      return res;
    }

// 7 *** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен циклически сместить все элементы массива на n позиций.
// [1,2,3,4,5], -2 => [3,4,5,1,2]
// [1,2,3,4,5], 2 => [4,5,1,2,3]


    public static int[] mooveArray(int[] inputArray, int n){
      int a = 0;
      if(n > 0){
        for(int i=0; i < n; i++){
          a = inputArray[inputArray.length-1];
          for(int j = inputArray.length-1; j > 0; j--){
            inputArray[j] = inputArray[j- 1];
            
          }
          inputArray[0] = a;
          
          // System.out.println(i + " " + Arrays.toString(inputArray));
        }
      }else{
        for(int i=0; i < Math.abs(n); i++){
          a = inputArray[0];
          for(int j = 0; j < inputArray.length -1 ; j++){
            inputArray[j] = inputArray[j + 1];
            
          }
          inputArray[inputArray.length - 1] = a;
          
          // System.out.println(i + " " + Arrays.toString(inputArray));
        }
        
      }
      return inputArray;
    }
  
}