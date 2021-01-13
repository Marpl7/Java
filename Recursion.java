import java.util.*;

class Main {
  public static void main(String[] args) {
    int n = 4;
    long startTime;
    long operationTime;
    int[] mArray = new int[10];
    int[] mArrayCopy;
    int key = 4;

    Random rand = new Random();
    for(int i = 0; i < mArray.length; i++){
      mArray[i] = rand.nextInt(15);

    }

    mArrayCopy = Arrays.copyOf(mArray, mArray.length);

    System.out.println(Arrays.toString(mArray));

    // countdown(n);
    countdownstop(n);

    startTime = System.nanoTime();
    factorialLoop(n);
    operationTime = System.nanoTime() - startTime;
    System.out.println("Время вычисления факториала циклом " + operationTime);

    startTime = System.nanoTime();
    System.out.println(factorial(n));
    operationTime = System.nanoTime() - startTime;
    System.out.println("Время вычесления факториала рекурсией " + operationTime);

    startTime = System.nanoTime();
    Arrays.sort(mArray);
    operationTime = System.nanoTime() - startTime;
    System.out.println("Время исполнения сортировки методом Sort " + operationTime);

    startTime = System.nanoTime();
    System.out.println(Arrays.toString(sortMerge(mArrayCopy)));
    operationTime = System.nanoTime() - startTime;
    System.out.println("Время исполнения сортировки слиянием " + operationTime);

    startTime = System.nanoTime();
    binarySearch(key, mArray);
    operationTime = System.nanoTime() - startTime;
    System.out.println("Время исполнения бинарного поиска " + operationTime);

    startTime = System.nanoTime();
    System.out.println(binarySearchR(key, 0, mArray.length - 1, mArray));
    operationTime = System.nanoTime() - startTime;
    System.out.println("Время исполнения бинарного поиска рекурсией " + operationTime);

   
  }

// Бесконечная рекурсия
  public static int countdown(int n){
    System.out.println(n);
    return countdown(n-1);
  }

// Рекурсия с условием по выходу
  public static int countdownstop(int n){
    System.out.println(n);
    if (n == 1){ 
      return 1;
    }
    return countdownstop(n-1);
    
  }

  // Простой алгоритм с использованием цикла
  public static void factorialLoop(int n){
    int res = 1;
    for (int i = 1; i <= n; i++){
      res = res*i;
    }
    System.out.println(res);
    
    
  }

  // Простой алгоритм с использованием рекурсии
  public static int factorial(int n){
    int res = 1;
    
    if (n == 1){ 
      return res;
    }
    res = n * factorial(n-1);
    return res;
    
  }

 //Бинарный поиск
   public static void binarySearch(int key, int[] mArray){
    int firstIndex = 0;
    int lastIndex = mArray.length - 1;

    while(firstIndex <= lastIndex){
      int midIndex = (firstIndex + lastIndex)/2;
      if(mArray[midIndex] == key){
        System.out.println("Значение " + key + " найдено в индексе " + midIndex);
        break;
      }else if(mArray[midIndex] < key){
        firstIndex = midIndex + 1;

      }else if(mArray[midIndex] > key){
        lastIndex = midIndex - 1;

      }

    }
   }

   //Бинарный поиск с рекурсией
   public static int binarySearchR(int key, int firstIndex, int lastIndex, int[] mArray){
    if(firstIndex > lastIndex){
      return mArray.length;
    }

    int midIndex = (firstIndex + lastIndex)/2;
    if(mArray[midIndex] == key){
      return midIndex;
    }else if(mArray[midIndex] > key){
      return binarySearchR(key, firstIndex, midIndex - 1, mArray);

      }else {
        return binarySearchR(key, midIndex + 1, lastIndex, mArray);

      }

    
   }


  //  Сортировка слиянием
 
   public static int[] merge(int[] a, int[] b){
     int[] result = new int[a.length + b.length];
     int aIndex = 0;
     int bIndex = 0;

     for(int i = 0; i < result.length; i++){
        result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
       if (aIndex == a.length){
         System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
         break;
       }
       if (bIndex == b.length){
         System.arraycopy(a, aIndex, result, ++i, a.length - aIndex);
         break;
       }
       
     }
     
     return result;

   }

   public static int[] sortMerge(int[] arr){
     int len = arr.length;
     if (arr.length < 2) {
       return arr; 
      }

     int mid = len/2;
     return merge(sortMerge(Arrays.copyOfRange(arr, 0, mid)),sortMerge(Arrays.copyOfRange(arr, mid, len)));

   }

}


// Пример рекурсии - задачи на вычисление чисел Фибоначчи или факториала. Под рекурсией понимают процесс повторения элементов самоподобным образом. Объект обладает рекурсией, если он является частью самого себя.
// Стек вызовов — стек, хранящий информацию для возврата управления из подпрограмм (функций) в программу или подпрограмму (при вложенных или рекурсивных вызовах). При вызове подпрограммы в стек заносится адрес возврата — адрес в памяти следующей инструкции приостанавливаемой программы, а управление передается подпрограмме. При последующем вложенном или рекурсивном вызове в стек заносится очередной адрес возврата и так далее.



