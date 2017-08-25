/*
和第Find Minimum in rotated array I 一样，在遇到重复数字时，左指针向右意移一位
*/

public class FindMin {
    public int findMin(int[] nums) {
        if(nums == null)
            return 0;
        if(nums.length  == 1)
            return nums[0];
        
        int res = nums[0];
        int start,end;
        
        start = 0;
        end = nums.length -1;
        
        while(start< end-1){  
            int mid = start + (end - start)/2;
            if(nums[start] < nums[mid]){
                res = Math.min(res,nums[start]);
                start = mid+1;
            }else if(nums[start] > nums[mid]){
                res = Math.min(res,nums[end]);
                end = mid;
            }else{
                start++;
            }
        }
        
        res = Math.min(res,nums[start]);
        res = Math.min(res,nums[end]);
        
        return res;
    }
}