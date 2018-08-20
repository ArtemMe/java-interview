package string_chapter_one;

public class Seventh {
    public void rotate(int[][] matrix, int sideLength){
        for(int layer = 0;layer< sideLength/2;layer++){
            int first = layer;
            int last = sideLength - 1 - layer;
            for(int i=first;i<last;i++){
                int offset = i - first;
                int top = matrix[first][i];
                //л->в
                matrix[first][first+offset] = matrix[last-offset][first];
                //н->л
                matrix[last-offset][first] = matrix[last][last-offset];
                //п->н
                matrix[last][last-offset] = matrix[first+offset][last];
                //в->п
                matrix[first+offset][last] = top;

            }
        }




    }
}
