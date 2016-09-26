import java.util.*;

public class MakeCarpet{

  private static ArrayList<String> stockCarpet = new ArrayList<String>();


  public static void main(String[]args){
    String line;
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()){
      line = sc.nextLine();
      stockCarpet.add(line);
    }
    switch(args[0]){
      case "-n": matchesAllowed();
                break;
      case "-m": maxAllowed();
                break;
      case "-b": bestBalanced();
                break;
    }
    printCarpetStock();
  }

  private static int carpetSize(int size){
    return size;
  }

  private static void matchesAllowed(){
    int count = 0;
    System.out.println("nigger");
  }

  private static void maxAllowed(){
    int count = 0;
    System.out.println("nigger1");
  }

  private static void bestBalanced(){
    System.out.println("nigger2");
  }

  private static void printCarpetStock(){
    System.out.println(stockCarpet);
  }
}
