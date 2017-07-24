/**
 * 1。利用backtracing可以很容易解答。注意helper方法的signature
 * 2. 利用BFS也可以
 */

import java.util.*;
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(nums.length == 0)
            return result;
        List<Integer> subset = new ArrayList<Integer>();
        helper(result,subset,nums,0);
        return result;       
    }
    
    public void helper(List<List<Integer>> result,List<Integer> subset,int[] nums,int start){
        result.add(new ArrayList<Integer>(subset));
        for(int i = start;i<nums.length;i++){
            subset.add(nums[i]);
            helper(result,subset,nums,i+1);
            subset.remove(subset.size()-1);
        }
    }
}