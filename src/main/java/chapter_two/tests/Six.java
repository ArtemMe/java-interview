package chapter_two.tests;

import chapter_two.MyLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Six {

    @Test
    public void testPolidrom(){
        MyLinkedList list = new MyLinkedList();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(list.isPolidrom(), true);
    }

    @Test
    public void testInvalidPolidrom(){
        MyLinkedList list = new MyLinkedList();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(2);
        assertEquals(list.isPolidrom(), false);
    }
}
