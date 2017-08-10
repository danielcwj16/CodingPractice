/**
 * 判断下标与该下标对应的元素是否相等，若果不相等，则交换两个数
 */

import java.util.*;

public class FirstMissingPositive{
    public int firstMissingPositive(int[] nums){
        if(nums == null || nums.length == 0)
            return 1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0 && nums[i] < nums.length && nums[i] != i && nums[nums[i]]!=nums[i])
                {
                    int t = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = t;
                    i--;
                }
        }

        for(int i = 1;i<nums.length;i++){
            if(nums[i]!= i)
                return i;
        }

        if(nums[0] == nums.length)
            return nums.length+1;
        else
            return nums.length;
    }
}