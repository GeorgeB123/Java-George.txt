import java.util.*;

public class harNums{

    private static LinkedHashMap<Integer, Integer> numbers = new LinkedHashMap<Integer, Integer>();

    public static void main(String[]args){
        pairs(2000000);
        for(Integer i : numbers.keySet()){
            System.out.println(i + " " + numbers.get(i));
        }
    }

    private static int sums(int num){
        int result = 0, i = 2, j;
        while(i<=(int)Math.sqrt(num)){
            if(num % i == 0){
                result+=i;
                j = num/i;
                if(j != i){
                    result+=j;
                }
            }
            i++;
        }
        return result;
    }

    private static void pairs(int max){
        int i = 2, j, k;
        while(i<=max){
            j = sums(i); k = sums(j);
            if(i == k && j != i){
                if(j<k){
                    if(numbers.get(j) == null) numbers.put(j, k);
                }else{
                    if(numbers.get(k) == null) numbers.put(k, j);
                }
            }
            i++;
        }
    }
}
