package codewars.factorial;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CastTest{
    public static void main(String args[ ] ){
        byte b = -128 ;
        int i = b ;
        b = (byte) i;
        System.out.println(i+" "+b);
    }
}
