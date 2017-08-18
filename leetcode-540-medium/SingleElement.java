/**
 * 相同的数字在抑或时，结果为0，剩下的数字则是single number
 */

import java.util.*;

public class SingleElement {
    public int singleNonDuplicate(int[] nums) {
        int num = nums[0];
        for(int i=1;i<nums.length;i++){
            num ^= nums[i];
        }
        
        return num;
    }
}