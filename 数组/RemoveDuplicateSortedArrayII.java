/**
 * 描述

Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
For example, given sorted array A = [1,1,1,2,2,3], your function should return length = 5, and A is now [1,1,2,2,3]
 */
import java.util.*;
 public class RemoveDuplicateSortedArrayII{
     public int removeduplicate(int[] nums){
         if(nums == null || nums.length ==0)
            return 0;
        int i =0 ;
        for(int n: nums){
            if(i<2 || n > nums[i-2]){
                nums[i++] = n;
            }
        }
        return i;
     }
 }

