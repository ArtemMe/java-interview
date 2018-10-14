package bets;

import java.util.Arrays;

public class TestAlgo {
    public static void main(String[] args){
        float [] in = {2,3,1,0.5f,3,1.6f};
        findAllPairs(in);
    }

    public static String findAllPairs(float[] intArr){
        Arrays.sort(intArr);

        float bigestVal = intArr[intArr.length-1];
        float minVal = bigestVal/(bigestVal-1);

        float[] cutArr = null;

        //generate new array with number greater than the minVal
        //TODO убрать генерацию вообще
        for(int i=0;i<intArr.length;i++){
            if(intArr[i]>minVal){
                cutArr = new float[intArr.length-i];
                System.arraycopy(intArr,i,cutArr,0,intArr.length-i);
                break;
            }
        }

        //collect combinations
        for(int i = 0;i<cutArr.length-1;i++){
            float border = cutArr[i]/(cutArr[i]-1);
            //start from the end until we reach the minimum value for a given number border
            for(int j = cutArr.length-1; cutArr[j]> border && j > i; j--){
                System.out.println(cutArr[i]+" - "+cutArr[j]);
            }
        }

        return null;
    }
}
