/**
 * 本来用排序可以很方便解题，但是时间复杂度为O(nlogn);如果要O(n)，则可以考虑hashmap，sequence 的边界为key，keep tracking sequence 的长度和最大长度
 */

import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int max = 0;
        
        for(int n: nums){
            if(!map.containsKey(n)){
                int length = 1;
                int left = map.containsKey(n-1) ? map.get(n-1) : 0;
                int right = map.containsKey(n+1) ? map.get(n+1) : 0;
                int sum = left + right +1;
                max = Math.max(max,sum);
                map.put(n,sum);
                
                if(map.containsKey(n-1)){
                    map.put(n-left,sum);
                }
                if(map.containsKey(n+1)){
                    map.put(n+right,sum);
                }
            }else{
                continue;
            }
        }
        return max;
    }
}