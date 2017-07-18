/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */

/**
 * O（n）时间以及o（1）的空间
 **/

import java.util.*;
public class RemoveDuplicateFromSortedArray {
    public int solution(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0;
        int cur = nums[i];
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == cur)
                continue;
            else {
                nums[i + 1] = nums[j];
                i++;
                cur = nums[j];
            }
        }
        return i + 1;
    }
}