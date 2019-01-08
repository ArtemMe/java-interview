package chapter_four;

import java.util.*;

public class Scramblies {

    public static boolean scramble(String str1, String str2) {
        HashMap<Character, Integer> map = new HashMap();

        for(int i=0;i<str1.length();i++){
            Character c = str1.charAt(i);
            if(map.containsKey(c)){
                int incr = map.get(c);
                map.put(c, ++incr);
            }else{
                map.put(c, 1);
            }
        }
        for(int i=0;i<str2.length();i++){
            Character c = str2.charAt(i);
            if(map.containsKey(c)){
                int incr = map.get(c);
                if(incr >0){
                    map.put(c, --incr);
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}