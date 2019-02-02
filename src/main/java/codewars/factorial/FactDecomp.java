package codewars.factorial;

import java.util.HashMap;
import java.util.Map;

class FactDecomp {

    public static String decomp(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<=n;i++){
            if(isPrimeNumber(i)){
                int sum = 0;
                int num = i;

                while(n/num != 0){
                    sum +=(n/num);
                    num= num*i;
                }
                result.append(i);
                if(sum > 1) {
                    result.append("^");
                    result.append(sum);
                }
                result.append(" * ");
            }
        }
        result.delete(result.length()-3, result.length());
        return result.toString();
    }

    public static boolean isPrimeNumber(int n){
        if(n==0 || n == 1) return false;

        for(int i=2;i<n;i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public static String show(Map<Integer, Integer> map){
        StringBuilder result = new StringBuilder();

        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            result.append(e.getKey());
            if(e.getValue() > 1) {
                result.append("^");
                result.append(e.getValue());
            }
            result.append(" * ");
        }

        result.delete(result.length()-3, result.length());

        return result.toString();
    }
}
