/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * merge sort 两个list， 然后用找mid，recursion的方法merge所有k个list
 */
public class MergeKSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0)
                return null;
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int left,int right){
        if(left < right){
            int mid = left + (right - left)/2;
            ListNode leftlist = merge(lists,left,mid);
            ListNode rightlist = merge(lists,mid+1,right);
            return mergeTwoLists(leftlist,rightlist);
        }
        return lists[left];
    }
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1!= null && l2 != null){
            if(l1.val < l2.val){
                head.next = l1;
                ListNode temp = l1.next;
                l1.next = null;
                l1 = temp;
            }else{
                head.next = l2;
                ListNode temp = l2.next;
                l2.next = null;
                l2 = temp;
            }
            head = head.next;
        }
        if(l1 != null){
            head.next = l1;
        }
        if(l2 != null){
            head.next = l2;
        }
        return dummy.next;
    }
}