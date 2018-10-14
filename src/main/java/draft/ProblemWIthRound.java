package draft;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;

public class ProblemWIthRound {
    public static void main(String[] args) {
        //Если сложить два дробных числа в double
        System.out.println(0.1 + 0.2); // -> 0.30000000000000004
        //Если использовать BigDecimal
        System.out.println(new BigDecimal("0.1").add(new BigDecimal("0.2")));// -> 0.3
        System.out.println(0.1/0.3);// -> 0.33333333333333337
        System.out.println(new BigDecimal("0.1").divide(new BigDecimal("0.3"),3, BigDecimal.ROUND_FLOOR));// -> 0.3

        ProblemWIthRound p = new ProblemWIthRound();
        Collection co = new HashSet();
        //ProblemWIthRound.print(co);
        p.print(co);
    }
    public  void print(Collection co){
        System.out.println("коллекция");
    }

    public  void print(HashSet set){
        System.out.println("сет");
    }
}
