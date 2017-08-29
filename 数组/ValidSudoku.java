import java.util.*;
/**
 * 按每行每列每一块进行valid
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return false;
        
        HashSet<Character> set = new HashSet<Character>();
            
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.')
                    continue;
                if(set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }
            set.clear();
        } 
        
        
        
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[j][i] == '.')
                    continue;
                if(set.contains(board[j][i]))
                    return false;
                set.add(board[j][i]);
            }
            set.clear();
        }
        
        
        
        for(int k = 0;k<9;k++){
            for(int i=k/3*3;i<k/3*3+3;i++){
                for(int j= k%3*3;j<k%3*3+3;j++){
                    if(board[i][j] == '.')
                        continue;
                    if(set.contains(board[i][j]))
                        return false;
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        
        return true;
    }
}