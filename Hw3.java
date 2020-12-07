

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static char[][] map;
    public static int sizeMapX;
    public static int sizeMapY;
    public static int numberToWin;

    public static final Scanner SCANNER = new Scanner(System.in);
    public static final Random RANDOM = new Random();

    public static final char HUMAN_DOT = 'X';
    public static final char AI_DOT = 'O';
    public static final char EMPTY_DOT = '_';

    public static void main(String[] args) {
        initMap();
        printMap();
        System.out.println('\n');
        while (true) {
            humanTurn();
            printMap();
            System.out.println('\n');
            if (checkWin(HUMAN_DOT)) {
                System.out.println("Human win!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printMap();
            System.out.println('\n');
            if (checkWin(AI_DOT)) {
                System.out.println("AI win!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw!");
                break;
            }
        }
        SCANNER.close();
    }

    public static void initMap() {
        sizeMapX = 5;
        sizeMapY = 5;
        numberToWin = 4;
        map = new char[sizeMapX][sizeMapY];
        for (int x = 0; x < sizeMapX; x++) {
            for (int y = 0; y < sizeMapY; y++) {
                map[x][y] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        for (int x = 0; x < sizeMapX; x++) {
            for (int y = 0; y < sizeMapY; y++) {
                System.out.print(map[x][y] + "|");
            }
            System.out.println();
        }
    }

    public static void humanTurn() {
        int x;
        int y;

        do {
            System.out.println("Введите координаты X, Y (от 1 до " + sizeMapX + ") через пробел: ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        map[x][y] = HUMAN_DOT;
    }

    public static void aiTurn() {
        int x;
        int y;
        int result [] = checkWinForAI(HUMAN_DOT, numberToWin - 1);
        x = result[2];
        y = result[3];
        // System.out.println(result[0] + " " + result[1] + " " + result[2] + " " + result[3] + " " + result[4]);
        if (result[0] !=4 ){
            if (result [0] == 0 && result[4] == 1) {
             
                map[x][y + 1] = AI_DOT;
                
            }else if (result [0] == 0 && result[4] == 0) {
                map[x][y - numberToWin + 1] = AI_DOT;

            }

            if (result [0] == 1 && result[4] == 1) {
              map[x + 1][y] = AI_DOT;
              
              }else if (result [0] == 1 && result[4] == 0){
                
                map[x - numberToWin + 1][y] = AI_DOT;

            }

            if (result [0] == 2 && result[4] == 1) {
              map[x + 1][y + 1] = AI_DOT;
              
              }else if ((result [0] == 2 && result[4] == 0)){
                map[x + 1 - numberToWin][y + 1 - numberToWin] = AI_DOT;

            }

            if (result [0] == 3 && result[4] == 1) {
              
              map[x - numberToWin + 1][y + 1] = AI_DOT;
                           
              }else if ((result [0] == 3 && result[4] == 0)){
                               
                map[x +1][y + 1 - numberToWin] = AI_DOT;

            }

            

        } else {

          do {
              x = RANDOM.nextInt(sizeMapX);
              y = RANDOM.nextInt(sizeMapY);
          } while (!isEmptyCell(x, y));
          map[x][y] = AI_DOT;

        }
    }

    public static boolean isValidCell(int x, int y) {
        return x >= 0 && x < sizeMapX && y >= 0 && y < sizeMapY;
    }

    public static boolean isEmptyCell(int x, int y) {
        return map[x][y] == EMPTY_DOT;
    }

    
    public static boolean checkWin(char symbol) {
      for(int k = 0; k <= sizeMapX - numberToWin; k++){
        
        for(int m = 0; m <= sizeMapY - numberToWin; m++){
          

          boolean leftDiagonal = true;
          boolean rightDiagonal = true;

          for (int i = k; i < numberToWin + k; i++){
            
            boolean colomn = true;
            boolean row = true;
            leftDiagonal &= (map[i][i - k + m] == symbol);
            rightDiagonal &= (map[i][numberToWin + m -1 - i + k] == symbol);     
          
            for(int j = m; j < numberToWin + m; j++){
              
              colomn &= (map[i][j] == symbol);
              row &= (map[j][i] == symbol);
            }
            if (colomn || row) return true; 
          }
        
          if(leftDiagonal || rightDiagonal) return true; 
          
      
        }
            
      }
      return false;
    }

    public static int[] checkWinForAI(char symbol, int numberToWin) {
      
      for(int k = 0; k <= sizeMapX - numberToWin; k++){
        
        for(int m = 0; m <= sizeMapY - numberToWin; m++){
          int x = 0;
          int y = 0;

          boolean leftDiagonal = true;
          boolean rightDiagonal = true;

          for (int i = k; i < numberToWin + k; i++){
            
            x = i;
            boolean colomn = true;
            boolean row = true;
            leftDiagonal &= (map[i][i - k + m] == symbol);
            rightDiagonal &= (map[i][numberToWin + m -1 - i + k] == symbol);     
          
            for(int j = m; j < numberToWin + m; j++){
              
              row &= (map[i][j] == symbol);
              colomn &= (map[j][i] == symbol);
              y = j;
            }

            if (y + 1 < sizeMapY && isEmptyCell(x,y +1)){
              if (row) return new int[] {0, 1,  x, y, 1}; 
            } else if (y - numberToWin >=0){
              if (row && isEmptyCell(x,y - numberToWin)) return new int[] {0, 1,  x, y, 0}; 
            }

            if (y + 1 < sizeMapX && isEmptyCell(y + 1,x)){
              if (colomn) return new int[] {1, 1,  y, x, 1}; 
             
            } else if (y - numberToWin >=0){
              if (colomn && isEmptyCell(y - numberToWin,x)) return new int[] {1, 1,  y, x, 0}; 
              
            }
            
          
          }
          
          if (y + 1 < sizeMapY && x + 1 < sizeMapX && isEmptyCell(x + 1,y +1)){
              if (leftDiagonal) return new int[] {2, 1,  x, y, 1}; 
            } else if (y - numberToWin >=0){
              if (leftDiagonal && isEmptyCell(x - numberToWin,y - numberToWin)) return new int[] {2, 1,  x, y, 0}; 
            }

            if (x - numberToWin >=0 && y + 1 < sizeMapY && isEmptyCell(x - numberToWin,y + 1)){
              if (rightDiagonal) return new int[] {3, 1,  x, y, 1}; 
            } else if (y - numberToWin >=0 && x + 1 < sizeMapX){
              if (rightDiagonal && isEmptyCell(x + 1,y - numberToWin)) return new int[] {3, 1,  x, y, 0}; 
            }
                
        }
            
      }
      return new int[] {4, 0, 0, 0, 2};
    }


    public static boolean isMapFull() {
        for (int x = 0; x < sizeMapX; x++) {
            for (int y = 0; y < sizeMapY; y++) {
                if (map[x][y] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
}