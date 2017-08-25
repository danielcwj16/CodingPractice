/**
 * 用Queue来记录当前window内最大元素的index，window的一个元素为最大
 */
import java.util.*;
public class SlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0)
            return new int[0];
        
        LinkedList<Integer> q = new LinkedList<Integer>();
        
        int[] res = new int[nums.length - k +1];
        
        for(int i=0;i<nums.length;i++){
            if(q.size() != 0 && q.getFirst() == (i-k))
                q.removeFirst();
            while(q.size() != 0 && nums[q.getLast()] < nums[i])
                q.removeLast();
            q.addLast(i);
            if(i+1>=k)res[i+1-k] = nums[q.getFirst()];
        }
        
        return res;
    }
}