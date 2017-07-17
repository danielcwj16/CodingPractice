/*
*Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

*Note: The solution set must not contain duplicate triplets.

*For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/


/*
 * 3sum 题，先对数组排序，然后用双层循环遍历。 从第一个数开始，跳过重复的数，对剩下数进行2sum查找；O(N*N)
 */

import java.util.*;
public class Solution{
    public List<List<Integer>> threesum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for(int i = 0;i<nums.length-2;i++){
            if(i == 0 || nums[i]!= nums[i-1]){
                int low = i+1,high = nums.length-1,sum = 0 - nums[i];
                while(low < high){
                    if(sum == nums[low] + nums[high]){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        res.add(temp);
                        while(low < high && nums[low] == nums[low+1])low++;
                        while(low < high && nums[high] == nums[high-1])high--;
                        low++;
                        high--;
                    }else if(nums[low]+nums[high] < sum) low++;
                    else
                        high--;

                }
            }
        }
        return res;
    }
}