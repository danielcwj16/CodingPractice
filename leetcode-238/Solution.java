import java.awt.List;

/**
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */



public class Solution {
    //方法1 ： 根据0的个数分情况讨论。遍历数组，统计0的个数。 没有0，则遍历计算乘积，1个0，除0所在位置以为其余乘积皆为0,2个0以上，所有元素都置为0；
    public int[] productExceptSelf(int[] nums) {
        int[] res  = new int[nums.length];
        Arrays.fill(res,0);
        int product = 1;
        List<Integer> zeroindexes = new ArrayList<Integer>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0)
                {   zeroindexes.add(i);
                    continue;}
            else{
                product *= nums[i];
            }
        }
        if(zeroindexes.size()>1)
            return res;
        else if(zeroindexes.size() == 1){
            res[zeroindexes.get(0)] = product;
            return res;
        }else{
            for(int i =0;i<nums.length;i++){
            res[i] = product/nums[i];
        }
    }
    return res;
}


//方法2： 不使用除法，两遍循环，第一次从左至右计算左半部乘积，第二次从右至左

public int[] productExceptSelf_method_two(int[] nums){
    int[] res = new int[nums.length];
    res[0] = 1;
    for(int i = 1;i<nums.length;i++){
        res[i] = res[i-1] * nums[i-1];
    }

    int right =1;
    for(int i = nums.length-1;i>=0;i--){
        res[i] *= right;
        right *= nums[i];
    }
    return res;
}
}

