import java.util.*;
/**
 * 求每一列左半部最高以及右半部最高，然后求trapping water
 * time  O(n）
 * space O(n)
 */
public class TrappingWater{
    public int trap(int[] height){
        if(height == null || height.length == 0)
            return 0;
        
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int maxleft = 0;
        for(int i=0;i<height.length;i++){
            left[i] = maxleft;
            maxleft = Math.max(maxleft,height[i]);
        }

        int maxright = 0;

        for(int j=height.length;j>=0;j--){
            right[j] = maxright;
            maxright = Math.max(maxright,height[j]);
        }

        int trap = 0;
        for(int k=0;k<height.length;k++){
            int t = Math.min(left[k],right[k]) - height[k];
            if(t <=0) continue;
            else{
                trap += t;
            }
        }

        return trap;
    }
}