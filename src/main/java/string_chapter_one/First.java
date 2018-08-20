package string_chapter_one;

/**
 *  Реализуйте алгоритм, определяющий, все ли символы в строке встречаются только один раз.
 *  А если при этом запрещено использование дополнительных структур данных?
 * */
public class First {
    public static void main(String[] args){
        String test1 = "aabcbbbb0";
        countCharacter(test1);
        System.out.println(isUniqueChars(test1));
    }

    public static void countCharacter(String str){
        char[] chars = str.toCharArray();
        char[] chars1 = new char[str.length()];
        boolean isMatching = false;
        int i = 0;

        for(char c : chars){
            for(char c1 : chars1){
                if(c==c1){
                    System.out.println("повторение символа "+c);
                    isMatching = true;
                    break;
                }
            }
            if(!isMatching){
                chars1[i] = c;
                i++;
            }
            isMatching = false;
        }
    }

    // решение из книжки, тут принимается что всего символов может быть 128
    public static boolean isUniqueChars(String str){
        if(str.length()>128) return false;

        boolean[] checkMass = new boolean[128];
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);

            if(checkMass[c] == true)
                return false;
            checkMass[c] = true;
        }
        return true;
    }

}
