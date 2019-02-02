package draft.codewars;

import java.util.*;

public class DigPow {

    public static long digPow(int n, int p) {
        List<Integer> list = new ArrayList<Integer>();
        int oldValue = n;
        while(n>0){
            int i = n%10;
            list.add(i);
            n = n/10;
        }
        int sum = 0;

        for(int i=list.size()-1; i>=0; --i){
            sum += Math.pow(list.get(i), p);
            p++;
        }

        if(sum%oldValue == 0) return sum/oldValue;

        return -1;
    }

}