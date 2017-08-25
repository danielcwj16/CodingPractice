/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 4.
 */
/**
 * 动态规划：
 * dp[x][y] = min(dp[x-1][y-1],dp[x-1][y],dp[x][y-1])+1
 * 以坐标x,y为右下角元素的正方形的最大边长
 * 
 * Time: O(m*n)
 * Space; O(m*n)
 */
 import java.util.*;
 class MaximumSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0] == '1')
            {
                dp[i][0] = 1;
                max = 1;
            }
        }

        for(int j = 0;j<matrix[0].length;j++){
           if(matrix[0][j] == '1'){
               dp[0][j] = 1;
               max =1;
           }
        }


        for(int i =1;i<matrix.length;i++){
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][j] == '0')
                    dp[i][j] = 0;
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        
        return max*max;
    }
}