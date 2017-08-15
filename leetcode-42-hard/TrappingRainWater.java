/**
 * 从左向右遍历，记录每个bar左边最高的高度，从右向左遍历，记录右边最高的高度。可以用两个数组记录。left[] , right[]
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        List<List<Integer>> bound = new ArrayList<List<Integer>>();
        int max = 0;
        for(int i = 0;i<height.length;i++){
            List<Integer> n = new ArrayList<Integer>();
            n.add(max);
            bound.add(n);
            max = Math.max(max,height[i]);
        }
        max = 0;
        
        for(int i=height.length-1;i>=0;i--){
            bound.get(i).add(max);
            max = Math.max(max,height[i]);
        }
        
        int sum=0;
        for(int i=0;i<height.length;i++){
            if(bound.get(i).get(0)>height[i]&&bound.get(i).get(1)>height[i]){
                sum += ((Math.min(bound.get(i).get(0),bound.get(i).get(1)))- height[i]);
            }
        }
        return sum;
    }
}