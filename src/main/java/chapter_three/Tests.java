package chapter_three;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    @Test
    public void ValidStackWIthMinTest(){
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(5);
        stackWithMin.push(6);
        stackWithMin.push(7);
        stackWithMin.push(3);

        assertEquals((int)stackWithMin.getMinValue(),3);

        stackWithMin.pop();

        assertEquals((int)stackWithMin.getMinValue(),5);
    }
}
