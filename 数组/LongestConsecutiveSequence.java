/**
 * 描述

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
Your algorithm should run in O(n) complexity.
 */

 import java.util.*;

 public class LongestConsecutiveSequence{
     public int findlongest(int[] nums){
         HashSet<Integer> set = new HashSet<Integer>();

         for(int n : nums){
             set.add(n);
         }

         int max = 0;

         for(int i = 0;i<nums.length;i++){
             if(set.contains(nums[i])){
                int count = 1;

                set.remove(nums[i]);

                int low = nums[i] -1;
                while(set.contains(low)){
                    set.remove(low);
                    low--;
                    count++;
                }

                int high = nums[i]+1;
                while(set.contains(high)){
                    set.remove(high);
                    high++;
                    count++;
                }

                max = Math.max(max, count);
             }else{
                 continue;
             }
         }

         return max;
     }
 }