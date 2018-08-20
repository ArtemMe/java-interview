package string_chapter_one;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Test15 {
    String s1 = "pale";
    String s2 = "pal";
    String s3 = "bale";
    String s4 = "balc";

    Fifth f;

    @Before
    public void init(){
        f= new Fifth();
    }

    @Test
    public void deletingChar(){
        assertEquals(f.checkModified(s1,s2),true);
    }

    @Test
    public void changeChar(){
        assertEquals(f.checkModified(s1,s3),true);
    }

    @Test
    public void changeSeveralTimesChar(){
        assertEquals(f.checkModified(s1,s4),false);
    }

    @Test
    public void deletingChar2(){
        assertEquals(f.onEditAway(s1,s2),true);
    }

    @Test
    public void changeChar2(){
        assertEquals(f.onEditAway(s1,s3),true);
    }

    @Test
    public void changeSeveralTimesChar2(){
        assertEquals(f.onEditAway(s1,s4),false);
    }

}
