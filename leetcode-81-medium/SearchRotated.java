/**
 * http://www.cnblogs.com/springfor/p/3859525.html
 * 
 * Time: O(n)
 * Space: O(1)
 * 将nums[start]<=nums[mid]分成两种情况讨论nums[start] < nums[mid] 和 nums[start] == nums[mid]
 */

import java.util.*;
class SearchRotated {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = start+ (end-start)/2;
            if(nums[mid] == target)
                return true;
            
            if(nums[start] < nums[mid]){
                 if(target<nums[mid]&&target>=nums[start]){
                     end = mid;
                 }else{
                     start = mid+1;
                 }
            }else if(nums[start]>nums[mid]){
                if(target>nums[mid]&&target <=nums[end]){
                    start = mid+1;
                }else{
                    end = mid;
                }
            }else{
                start++;
            }
        }
        
        return false;
    }

    public boolean helper(int[] nums,int target){
        int first = 0, last = nums.length;
        while (first != last) {
            final int mid = first  + (last - first) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[first] < nums[mid]) {
                if (nums[first] <= target && target < nums[mid])
                    last = mid;
                else
                    first = mid + 1;
            } else if (nums[first] > nums[mid]) {
                if (nums[mid] < target && target <= nums[last-1])
                    first = mid + 1;
                else
                    last = mid;
            } else
                //skip duplicate one
                first++;
        }
        return false;
    }
}