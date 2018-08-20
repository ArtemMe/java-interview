package string_chapter_one;

import static java.util.Arrays.sort;

/**
 * Для перестановки строк напишите метод, определяющий, является ли одна строка перестановкой другой.
 * */

public class Second {
    public static void main(String[] args){
        boolean b = permutation("abc", "abc");
        System.out.println(b);
    }

    //методо из книжки с использованием сортировки
    public static boolean permutation(String s1, String s2){
        char[] massChar1 = s1.toCharArray();
        char[] massChar2 = s2.toCharArray();

        sort(massChar1);
        sort(massChar2);

        return new String(massChar1).equals(new String(massChar2));
    }
}
