import java.util.*;
/**
 * 上下翻转，然后再沿对角线翻转
 * Time O(n2)
 * space O(1)
 *
 */
public class RotateImage{
    public void rotate(int[][] matrix){
        if(matrix == null || matrix.length == 0)
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<=matrix.length/2-1;i++){
            for(int j = 0;j<matrix[0].length;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[m-1-i][j];
                matrix[m-1-i][j] = tmp;
            }
        }

        for(int i=0;i<m;i++){
            for(int j = i;j<m;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        return;
    }
}
