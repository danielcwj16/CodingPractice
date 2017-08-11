import java.util.*;

public class MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        int min = findmin(nums);
        int max = findmax(nums);
        
        int len = (int)Math.ceil((double)(max-min)/(nums.length-1));
        if(len == 0)
            return max - min;
        Bucket[] buckets = new Bucket[(max-min)/len+1];
        init(buckets);
        fill(buckets,nums,min,len);
        return findmaxGap(buckets);
    }
    
    public int findmin(int[] nums){
        int min = nums[0];
        for(int i=1;i<nums.length;i++){
            min = Math.min(min,nums[i]);
        }
        
        return min;
    }
    
    public int findmax(int[] nums){
        int max = nums[0];
        for(int j = 1;j<nums.length;j++){
            max = Math.max(max,nums[j]);
        }
        return max;
    }
    
    public void init(Bucket[] buckets){
        for(int i = 0;i<buckets.length;i++){
            buckets[i] = new Bucket();
        }
    }
    
    public void fill(Bucket[] buckets,int[] nums,int min,int len){
        for(int n : nums){
            int index = (n - min)/len;
            buckets[index].min = Math.min(buckets[index].min,n);
            buckets[index].max = Math.max(buckets[index].max,n);
        }
    }
    
    public int findmaxGap(Bucket[] buckets){
        int maxGap = Integer.MIN_VALUE;
        int premax = Integer.MIN_VALUE;
        int curmin = Integer.MAX_VALUE;
        for(int i = 0;i<buckets.length;i++){
            if(buckets[i].min != Integer.MAX_VALUE)
                curmin = buckets[i].min;
            if(premax != Integer.MIN_VALUE)                
                maxGap = Math.max(curmin - premax,maxGap);
            if(buckets[i].max != Integer.MIN_VALUE)
                premax = buckets[i].max;
        }
        return maxGap;
    }
    
    public class Bucket{
        int min;
        int max;
        Bucket(){
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
        }
    }
}