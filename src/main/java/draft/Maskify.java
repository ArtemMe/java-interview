package draft;

public class Maskify {
    public static String maskify(String str) {
        if(str.length() <= 4) return str;

        StringBuilder sb = new StringBuilder();
        int numChar = str.length() - 4;

        for(int i=0; i < numChar; i++){
            sb.append("#");
        }
        return sb+str.substring(numChar, str.length()-1);
    }
}
