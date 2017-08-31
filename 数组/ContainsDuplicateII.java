

import java.util.*;

public class ContainsDuplicateII{
    public boolean containsnearbyduplicate(int[] nums,int k){
        if(nums == null || nums.length < 2) 
            return false;
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int idx = map.get(nums[i]);
                if(Math.abs(i-idx) <= k)
                    return true;
                else{
                    map.put(nums[i],i);
                }
            }else{
                map.put(nums[i],i);
            }
        }
        
        return false;


        //解法二
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0;i<nums.length;i++){
            if(i>k){
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])) return true;
        }   

        return false;
        
    }
}