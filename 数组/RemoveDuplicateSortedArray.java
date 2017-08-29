/**
 * 描述

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example, Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].
O(n) time
O(1) space
 */

 import java.util.*;

 public class RemoveDuplicateSortedArray{
     public int removeduplicate(int[] nums){
        if(nums == null || nums.length == 0)
        return 0;

        int num = nums[0];
        int i = 1;
        for(int j =1;j<nums.length;j++){
            if(nums[j]!= num){
                nums[i] = nums[j];
                num = nums[j];
                i++;
            }
        }
        return i;
     }
 }