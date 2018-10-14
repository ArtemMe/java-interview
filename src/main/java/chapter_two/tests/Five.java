package chapter_two.tests;

import chapter_two.MyLinkedList;
import org.junit.Test;

public class Five {
    @Test
    public void test1(){
        MyLinkedList list1 = new MyLinkedList();
        list1.add(7);
        list1.add(1);
        list1.add(6);
        list1.add(6);
        MyLinkedList list2 = new MyLinkedList();
        list2.add(5);
        list2.add(9);
        list2.add(2);

        chapter_two.Five five = new chapter_two.Five();
        MyLinkedList list = five.addTwoList(list1,list2);
        list.printData();
    }
}
