
/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
/**
 * 合并数组或者list，从数组尾端开始比较，添加至nums1的末端，这样可以实现inplace merge
 *
 */
import java.util.*;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j < 0) {
                nums1[i + j + 1] = nums1[i];
                i--;
                continue;
            }
            if (i < 0 && j >= 0) {
                nums1[i + j + 1] = nums2[j];
                j--;
                continue;
            }
            if (nums1[i] > nums2[j]) {
                nums1[i + j + 1] = nums1[i];
                i--;
            } else {
                nums1[i + j + 1] = nums2[j];
                j--;
            }
        }
    }
}