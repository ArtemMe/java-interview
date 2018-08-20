package string_chapter_one;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    private Third t;
    String p1 = "oooppp";
    String p2 = "poooop";
    String p3 =  "poopoop";
    String p4 =  "popoop";
    String p5 = "abckcba";
    String p6 = "abccba";
    String p7 = "abccbal";

    @Before
    public void init(){
        t = new Third();
    }

    @Test
    public void evenPolidrom1(){
        assertEquals(t.isPolidrom(p1),false);
    }

    @Test
    public void evenPolidrom2(){
        assertEquals(t.isPolidrom(p2),true);
    }

    @Test
    public void oddPolidrom3(){
        assertEquals(t.isPolidrom(p3),true);
    }

    @Test
    public void oddPolidrom4(){
        assertEquals(t.isPolidrom(p4),false);
    }

    @Test
    public void oddPolidrom5(){
        assertEquals(t.isPolidrom(p5),true);
    }

    @Test
    public void oddPolidrom6(){
        assertEquals(t.isPolidrom(p6),true);
    }
    @Test
    public void oddPolidrom7(){
        assertEquals(t.isPolidrom(p7),true);
    }
    @Test
    public void PolidromWithHashMap1(){
        assertEquals(t.isPolidromWithHashMap(p1),false);
    }
    @Test
    public void PolidromWithHashMap2(){
        assertEquals(t.isPolidromWithHashMap(p2),true);
    }
}
