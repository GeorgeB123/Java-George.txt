import java.util.*;
import javafx.util.Pair;
import java.lang.*;
    
public class CountUp{

    private static Map<Pair<Long, Long>, Long> cache = new HashMap<>();
    
    public static long choose(long n, long k){
        if (k < 0 || k > n) return 0;
        if(n == k) return 1;
        if (cache.containsKey(new Pair<>(n, k))) {
            return cache.get(new Pair<>(n, k));
        } else {
            Long a = cache.get(new Pair<>(n - 1, k - 1));
            if (a == null) { a = choose(n - 1, k - 1); }
            Long b = cache.get(new Pair<>(n - 1, k));
            if (b == null) { b = choose(n - 1, k); }

            cache.put(new Pair<>(n, k), a + b);
            return a + b;
        }
    }

    public static void main(String[]args){
        Long k = Long.parseLong(args[1]);
        Long n = Long.parseLong(args[0]);
        System.out.println(choose(n, k));
    }

}
