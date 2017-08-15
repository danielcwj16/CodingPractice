/**
 * time: O(n3)
 * space: O(n2)
 * 注意循环边界
 * https://www.youtube.com/watch?v=IFNibRVgFBo
 * 
 */

import java.util.*;

public class BurstBaloons{
    //方法1： BFS 超时
private int max = 0;
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length ==0)
            return max;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        
        helper(list,0);
        
        return max;
    }
    
    public void helper(ArrayList<Integer> nums,int sum){
        if(nums.size() == 0){
            max = Math.max(max,sum);
            return;
        }
        
        for(int i=0;i<nums.size();i++){
            int left = (i-1) <0 ? 1 : nums.get(i-1);
            int right = (i+1) >=nums.size() ? 1 : nums.get(i+1);
            int current = nums.get(i);
            int points = left * current * right;
            nums.remove(i);
            helper(nums,sum+points);
            nums.add(i,current);
        }
        
        return;
    }

    public int correctSolution(int[] nums){
        if(nums == null || nums.length ==0)
            return 0;
        int[][] dp = new int[nums.length][nums.length];
        
        for(int len=1;len<=nums.length;len++){
            for(int i=0;i<nums.length-len;i++){
                int j = i+len-1;
                for(int k=i;k<=j;k++){
                    int leftvalue = 1;
                    int rightvalue = 1;
                    if(i!=0)
                        leftvalue = nums[i-1];
                    if(j!=nums.length-1)
                        rightvalue = nums[j+1];
                    
                    int before = 0;
                    int after = 0;
                    if(k != i)
                        before = dp[i][k-1];
                    if(k!=j)
                        after = dp[k+1][j];
                    
                    dp[i][j] = Math.max(before+after+leftvalue*nums[k]*rightvalue,dp[i][j]);
                }
            }
        }
        
        return dp[0][nums.length-1];
}
}

