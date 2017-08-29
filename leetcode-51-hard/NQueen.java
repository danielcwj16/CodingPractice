/*
http://www.cnblogs.com/springfor/p/3870944.html
经典N皇后题，用DFS加回溯
一维数组记录皇后位置
 */
import java.util.*;
class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        if(n <= 0)
            return res;
        
        //use array to record the location of queen, index 是横坐标, val 是纵坐标
        int[] colVal = new int[n];
        helper(n,0,res,colVal);
        return res;
    }
    
    public void helper(int n, int row, List<List<String>> res, int[] colVal){
        if(row == n){
            ArrayList<String> sol = new ArrayList<String>();
            
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j<n;j++){
                    if(j == colVal[i]){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                sol.add(sb.toString());
            }
            res.add(sol);
            
        }else{
            for(int i=0;i<n;i++){
                colVal[row] = i;
                if(isValid(row,colVal)){
                    helper(n,row+1,res,colVal);
                }
            }
        }
    }
    
    public boolean isValid(int row,int[] colVal){
        for(int i = 0;i<row;i++){
            if(colVal[row] == colVal[i] || Math.abs(colVal[row]-colVal[i]) == row -i)
                return false;
        }
        return true;
    }
}