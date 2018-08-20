package string_chapter_one;

import org.junit.Before;
import org.junit.Test;


public class Test17 {

    Seventh seventh;
    int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
    };
    @Before
    public void init(){
        seventh = new Seventh();
    }

    @Test
    public void validTest1(){
        System.out.println("Before");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("=============");
        System.out.println("After");
        seventh.rotate(matrix,4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
