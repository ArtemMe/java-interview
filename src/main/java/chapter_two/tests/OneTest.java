package chapter_two.tests;

import chapter_two.One;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class OneTest {
    List<Integer> list = new LinkedList<>();
    One one;

    @Before
    public void init(){
        one = new One();

        list.add(5);
        list.add(10);
        list.add(10);
        list.add(3);
        list.add(8);
        list.add(7);
        list.add(6);
        list.add(3);
        list.add(6);
    }

    @Test
    public void test(){
        list.forEach(System.out::print);
        System.out.println("\n");
        List resutl = one.deleteDups(list);
        resutl.forEach(System.out::print);
    }


    @Test
    public void testWithLambda(){
        list.forEach(System.out::print);
        System.out.println("\n");
        List resutl = one.deleteDupsWithLambda2(list);
        resutl.forEach(System.out::print);
    }
}
