
import java.util.*;

public class ContainsDuplicate{
    public boolean containsduplicate(int[] nums){
        if(nums == null || nums.length == 0)
            return false;
        
        HashSet<Integer> set = new HashSet<Integer>();

        for(int n : nums){
            if(set.contains(n)){
                return true;
            }else{
                set.add(n);
            }
        }

        return false;
    }
}