import java.util.*;

public class ContainsDuplicateIII{
    public boolean containsnearbyDuplicate(int[] nums,int k,int t){
        if(k<0 || t < 0)
            return false;   
        TreeSet<Integer> tree = new TreeSet<Integer>();

        for(int i = 0;i<nums.length;i++){
            int x = nums[i];

            Integer floor = tree.floor(x);
            Integer ceiling = tree.ceiling(x);

            if((floor != null && x-floor <= t) || (ceiling != null && ceiling -x <= t))
                return true;
            

            tree.add(x);
            if(i >=k){
                tree.remove(nums[i-k]);
            }
        }
        return false;


        ///
        if (k < 1 || t < 0) return false;

        final TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            final int x = nums[i];
            final Integer floor = set.floor(x);
            final Integer ceiling = set.ceiling(x);

            if ((floor != null && x <= floor + t) || (ceiling != null && x >= ceiling -t))
                return true;

            set.add(x);
            if (i >= k) set.remove(nums[i - k]);
        }

        return false;
    }
}