/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ? k ? array's length.
 */
public class KthLargest{
    public findKthLargest(int[] nums,int k){
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int n : nums){
            q.add(n);
            if(q.size()>k){
                q.poll();
            }
        }
        q.peek();
    }
}