package chapter_three.tests;

import chapter_three.FixedMultiStack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class One {
    @Test
    public void validTestPushPop(){
        FixedMultiStack<Integer> stack = new FixedMultiStack<>(Integer.class, 10);
        stack.push(11,0);
        stack.push(21,1);
        stack.push(31,2);

        stack.push(12,0);
        stack.push(22,1);
        stack.push(32,2);

        assertEquals(stack.pop(0), new Integer(12));
        assertEquals(stack.pop(1), new Integer(22));
        assertEquals(stack.pop(2), new Integer(32));
    }
    @Test
    public void validIsEmpty(){
        FixedMultiStack<Integer> stack = new FixedMultiStack<>(Integer.class, 10);
        assertEquals(stack.isEmpty(0),true);
        assertEquals(stack.isEmpty(1),true);
        assertEquals(stack.isEmpty(2),true);

        stack.push(11,0);
        stack.push(21,1);
        stack.push(31,2);

        assertEquals(stack.isEmpty(0),false);
        assertEquals(stack.isEmpty(1),false);
        assertEquals(stack.isEmpty(2),false);
    }
}
