import java.util.*;

public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        // boolean[] rows = new boolean[matrix.length];
        // boolean[] cols = new boolean[matrix[0].length];

        boolean rowhaszero = false;
        boolean colhaszero = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                rowhaszero = true;
                break;
            }
        }

        for(int i= 0;i<matrix.length;i++){
            if(matrix[i][0] == 0){
                colhaszero = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(rowhaszero){
            for(int i=0;i<matrix[0].length;i++){
                matrix[0][i] = 0;
            }
        }
        
        if(colhaszero){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }

        return;
    }
}