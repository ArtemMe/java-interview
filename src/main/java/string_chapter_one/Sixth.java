package string_chapter_one;

public class Sixth {
    public String compress(String str){
        StringBuilder result = new StringBuilder();
        int counter = 0;
        for(int i=0;i<str.length();i++){
            if(i+1 <str.length() && str.charAt(i) == str.charAt(i+1)){
                counter++;
            }else{
                result.append(str.charAt(i));
                result.append(counter);
                counter = 0;
            }
        }
        return result.toString();
    }
}
