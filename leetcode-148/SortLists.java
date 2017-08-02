/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 折半，每次找到list的中点，对firsthalf和secondhalf尽心排序，再归并
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode slow = head,fast = head,firsthalf = head;
        while(fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode secondhalf  = slow.next;
        slow.next = null;
        ListNode leftlist=null;
        ListNode rightlist=null;
        
        if(firsthalf != secondhalf){
            leftlist = sortList(firsthalf);
            rightlist = sortList(secondhalf);
        }
        return mergeList(leftlist,rightlist);
    }
    
    public ListNode mergeList(ListNode left,ListNode right){
        if(left == null)
            return right;
        if(right == null)
            return left;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(left!= null && right != null){
            if(left.val < right.val){
                head.next = left;
                head = head.next;
                left = left.next;
            }else{
                head.next = right;
                head= head.next;
                right = right.next;
            }
        }
        
        if(left == null)
            head.next = right;
        if(right == null)
            head.next = left;
        return dummy.next;
    }
}