/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.*;
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)
            return head;
        
        ListNode first = new ListNode(0);
        ListNode p1 = first;
        ListNode second = new ListNode(0);
        ListNode p2 = second;
        
        while(head != null)
        {
            ListNode tmp = head.next;
            if(head.val < x){
                p1.next = head;
                p1 = p1.next;
            }else{
                p2.next = head;
                p2 = p2.next;
            }
            head.next = null;
            head = tmp;
        }
        p1.next = second.next;
        
        return first.next;
    }
}