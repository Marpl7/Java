import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;
import java.io.File;

class Main {
  
  public static void main(String[] args){
    InputStream io;
    OutputStream os;

    String fileIn1 = "text1.txt";
    String fileIn2 = "text2.txt";
    String fileOut = "text3.txt";
    String text1 = "Java was originally developed by James Gosling at Sun Microsystems (which has since been acquired by Oracle) and released in 1995 as a core component of Sun Microsystems' Java platform. The original and reference implementation Java compilers, virtual machines, and class libraries were originally released by Sun under proprietary licenses. ";
    String text2 = " As of May 2007, in compliance with the specifications of the Java Community Process, Sun had relicensed most of its Java technologies under the GNU General Public License. Oracle offers its own HotSpot Java Virtual Machine, however the official reference implementation is the OpenJDK JVM which is free open source software and used by most developers and is the default JVM for almost all Linux distributions.";
    String word = "Java";

    

    createFile(fileIn1, text1);
    createFile(fileIn2, text2);
    mergeFiles(fileIn1, fileIn2, fileOut);

    System.out.println("Поиск по в файле: ");
    
    try{
      if(searchWord(fileOut, word) !=0){
          System.out.println(searchWord(fileOut, word) + " words " + word + " found in the file " + fileOut);
        }else{
          System.out.println("Zero words " + word + " found in the file " + fileOut);
        }
    }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
System.out.println("Поиск по всем файлам в папке: ");
    try{
      
    for(int i = 0; i < getFiles().length; i ++){
      if((getFiles()[i] != null)){
        if((searchWord(getFiles()[i], word) > 0)){
          System.out.println(searchWord(getFiles()[i], word) + " words " + word + " found in the file " + (getFiles()[i]));
        }
      }
      
    }
  }catch (Exception ex) {
                throw new RuntimeException(ex);
      }
      
  }

  public static void createFile(String fileName, String text){
    try {
      FileOutputStream fos = new FileOutputStream(fileName);
      PrintStream ps = new PrintStream(fos);
      ps.println(text);

      ps.close();
      fos.flush();
      fos.close();
       } catch (FileNotFoundException e) {
           System.out.println("File not found " + e.getMessage());
       } catch (IOException e) {
           System.out.println("Something wrong: " + e.getMessage());
       }

  }

  public static void mergeFiles(String fileIn1, String fileIn2, String fileOut) {
      
    try {
            FileOutputStream fos = new FileOutputStream(fileOut, true);
            FileInputStream fis = new FileInputStream(fileIn1);
            int outbox;
            while ((outbox = fis.read()) != -1) {
                fos.write(outbox);
                fos.flush();
            }
            fis.close();

            fis = new FileInputStream(fileIn2);
            while ((outbox = fis.read()) != -1) {
                fos.write(outbox);
                fos.flush();
            }
            fis.close();
            fos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
      }

    public static int searchWord(String fileName, String word) throws IOException{

      FileInputStream fis = new FileInputStream(fileName);
      int count = 0;
      int letter;
      String words = "";
      while ((letter = fis.read()) != -1) {
              
              if((int)letter != 32){
                words += (char)letter;
                if(words.equals(word)){
                count += 1;
                } 
              }else{
                words = "";
              }
            
              
            }
      fis.close();

      return count;

      


    }

    // Вытаскиваем все txt файлы из директории
    public static String[] getFiles() throws IOException{
      
      int count = 0;
      String name;
      String ext;
      File path = new File(new File(".").getCanonicalPath());
      String[] list = new String[path.listFiles().length];

      for (File file : path.listFiles()){
        name = file.getName();
        ext = name.substring(name.length() - 3);
        // System.out.println(name.substring(name.length() - 3));
        if(ext.equals("txt")){
          list[count] = name;
          count += 1;
        }
      }


      return list;
    }

}