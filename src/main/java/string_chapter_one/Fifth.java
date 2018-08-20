package string_chapter_one;

public class Fifth {
    public boolean checkModified(String s1, String s2){
        if(s1.equals(s2))
            return false;

        char[] mass1 = s1.toCharArray();
        char[] mass2 = s2.toCharArray();

        int deverseCharacter = mass1.length - mass2.length;

        if(deverseCharacter > 1 || deverseCharacter < -1)
            return false;

        int error = 0;

        if(deverseCharacter ==1){
            for(int i=0;i<mass1.length;i++){
                for(int j=i;j<mass2.length;j++){
                    if(mass1[i]==mass2[j]){
                        break;
                    }
                    if(mass1[i+1]==mass2[j]){
                        error++;
                        i++;
                        if(error>1) {
                            return false;
                        }
                        break;
                    }
                    return false;
                }
            }
        }
        if(deverseCharacter == -1){
            for(int i=0;i<mass1.length;i++){
                for(int j=i;j<mass2.length;j++){
                    if(mass1[i]==mass2[j]){
                        break;
                    }
                    if(mass1[i]==mass2[j+1]){
                        error++;
                        j++;
                        if(error>1) {
                            return false;
                        }
                        break;
                    }
                    return false;
                }
            }
        }

        if(deverseCharacter == 0){
            for(int i=0;i<mass1.length;i++){
                for(int j=i;j<mass2.length;j++){
                    if(mass1[i]==mass2[j]){
                        break;
                    }
                    error++;
                    if(error>1)
                        return false;
                    break;
                }
            }
        }
        return true;
    }

    //алгоритм выполняется за время O(n)
    public boolean onEditAway(String s1, String s2){
        if(s1.length() - s2.length() ==1){
            return oneEditInsert(s1,s2);
        }else if(s1.length() - s2.length() == -1){
            return oneEditReplace(s2,s1);
        }else if(s1.length() == s2.length()){
            return oneEditReplace(s1,s2);
        }
        return true;
    }

    public boolean oneEditInsert(String s1, String s2){
        int counter1 = 0;
        int counter2 = 0;
        while(counter1 < s1.length() && counter2 < s2.length()){
            if(s1.charAt(counter1) != s2.charAt(counter2)){
                if(counter1 != counter2){
                    return false;
                }
                counter1++;
            }else{
                counter1++;
                counter2++;
            }
        }
        return true;
    }
    public boolean oneEditReplace(String s1, String s2){
        boolean foundDifference = false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                if(foundDifference){
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }
}
