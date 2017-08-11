/**
 * 题解链接：https://segmentfault.com/a/1190000003786782
 */

import java.util.*;
public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        ArrayList<int[]> result = new ArrayList<int[]>();
        ArrayList<int[]> height = new ArrayList<int[]>();
        
        for(int[] b : buildings){
            height.add(new int[]{b[0],-b[2]});
            height.add(new int[]{b[1],b[2]});
        }//将左右顶点放入列表，坐顶点的高度记为负数
        
        Collections.sort(height,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }else{
                    return a[1]-b[1];
                }
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10,new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });//tracking 当前最高高度的堆
        
        pq.offer(0);
        
        int prev = 0;
        for(int[] h : height){
            if(h[1]<0){
                pq.offer(-h[1]);
            }else{
                pq.remove(h[1]);
            }
            
            int curr = pq.peek();
            if(prev != curr){
                result.add(new int[]{h[0],curr});
                prev = curr;
            }
        }
        return result;
    }
}