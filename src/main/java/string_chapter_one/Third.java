package string_chapter_one;

import java.util.HashMap;

public class Third {
    public boolean isPolidrom(String str){
        char [] chars = new char[str.length()];
        boolean [] massChars = new boolean[128];
        if(str.length()%2==0){
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(massChars[c]==true)
                    continue;
                massChars[c] = true;
                int counter=1;
                for(int j=i+1; j<str.length();j++){
                    if(c==str.charAt(j))
                        counter++;
                }
                if(counter%2!=0)
                    return false;
                counter=0;
            }
        }else{
            int counterOddChar = 0;
            for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
                if(massChars[c]==true)
                    continue;
                massChars[c] = true;
                int counter=1;
                for(int j=i+1; j<str.length();j++){
                    if(c==str.charAt(j))
                        counter++;
                }
                if(counter%2!=0) {
                    counterOddChar++;
                    if (counterOddChar == 2)
                        return false;
                }
                counter=0;
            }

        }
        return true;
    }
    public boolean isPolidromWithHashMap(String str){
        HashMap<Character,Integer> map = new HashMap();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(map.containsKey(c)) {
                Integer counter = map.get(c);
                map.put(c, ++counter);
            } else
                map.put(c,1);

        }
        if(str.length()%2==0){
            for(int i : map.values()){
                if(i%2!=0)
                    return false;
            }
        }else{
            int counterOddChar = 0;
            for(int i : map.values()){
                if(i%2!=0) {
                    counterOddChar++;
                    if (counterOddChar == 2)
                        return false;
                }
            }
        }
        return true;
    }
}
