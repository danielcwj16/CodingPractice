/**
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
 */
import java.util.*;
 class CombinationSum {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k == 0 || k>9 || n> 45)
            return res;
        
        helper(k,n,res,new ArrayList<Integer>(),1);
        return res;
    }

    public void helper(int k,int n,List<List<Integer>> res,List<Integer> com,int left){
        if(k == 0 && n == 0){
            res.add(new ArrayList<Integer>(com));
            return;
        }

        if(k == 0 && n != 0)
            return;
        
        for(int i = left;i<=9;i++){
            com.add(i);
            helper(k-1,n-i,res,com,i);
            com.remove(com.size()-1);
        }
        
        return;
    }
}