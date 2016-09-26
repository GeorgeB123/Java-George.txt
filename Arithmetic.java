import java.util.*;

public class Arithmetic {

    private static char[] plusTimes = {'+', '*'};
    private static ArrayList<Character> newOperations = new ArrayList<>();

    private static int leftToRight(boolean first, int sum, ArrayList<Integer> numbs,
                                  ArrayList<Character> ops){
        if (first){
            sum = numbs.get(0);
            numbs.remove(0);
        }
        if (numbs.size() > 0) {
            if (ops.get(0) == '+') {
                sum += numbs.get(0);
            } else {
                sum *= numbs.get(0);
            }
            numbs.remove(0);
            ops.remove(0);
        } else {
            return sum;
        }
        return leftToRight(false, sum, numbs, ops);
    }

    private static int normal(final ArrayList<Integer> numbs, final ArrayList<Character> ops){
        int sum = 0;
        for (int i = 0; i < ops.size(); i++){
            if (ops.get(i) == '*') {
                int sumTimes = numbs.get(i) * numbs.get(i + 1);
                numbs.remove(i);
                numbs.remove(i);
                numbs.add(i, sumTimes);
                ops.remove(i);
                i -= 1;
            }
        }
        for (Integer n : numbs){
            sum += n;
        }
        return sum;
    }

    private static void formula(final char order, final ArrayList<Integer> numbs,
                                    ArrayList<Character> operations, final int targ){
        if (operations.size() == numbs.size() - 1){
            final ArrayList<Integer> nums = new ArrayList<>(numbs);
            final ArrayList<Character> ops = new ArrayList<>(operations);
            if(order == 'N'){
                if (normal(nums, ops) == targ) {
                    newOperations = operations;
                }
            }else{
                if (leftToRight(true, 0, nums, ops) == targ) {
                    newOperations = operations;
                }
            }
        } else {
            for (char c: plusTimes) {
                final ArrayList<Character> oldOps = new ArrayList<>(operations);
                final ArrayList<Character> newOps = new ArrayList<>(operations);
                newOps.add(c);
                formula(order, numbs, newOps, targ);
                operations = oldOps;
            }
        }
    }

    public static void calculate(final Scanner sc, final ArrayList<Integer> numbs,
                                      boolean newLine){
      while (sc.hasNextLine()) {
          final String line = sc.nextLine();
          final String[] lineArray = line.split(" ");
          if (newLine) {
              newLine = false;
              numbs.clear();
              newOperations.clear();
              for (String s : lineArray){
                  numbs.add(Integer.parseInt(s));
              }
          } else {
              final char order = lineArray[1].charAt(0);
              final int target = Integer.parseInt(lineArray[0]);
              formula(order, numbs, new ArrayList<>(), target);

              if (newOperations.size() == 0 && numbs.get(0) != target){
                  System.out.println(order + " impossible");
              } else {
                  System.out.print(order + " ");
                  for (int i = 0; i < numbs.size(); i++){
                      if (newOperations.size() > i){
                          System.out.print(numbs.get(i) + " " + newOperations.get(i) + " ");
                      } else {
                          System.out.print(numbs.get(i));
                      }
                  }
                  System.out.println();
              }
              newLine = true;
            }
        }
    }

    public static void main(String args[]) {
        final Scanner sc = new Scanner(System.in);
        final ArrayList<Integer> numbs = new ArrayList<>();
        boolean newLine = true;
        calculate(sc, numbs, newLine);
    }
}
