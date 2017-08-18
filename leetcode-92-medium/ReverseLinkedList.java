/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /**
  * http://www.cnblogs.com/springfor/p/3864303.html

  参考翻转链表经典题。
  本题用三个指针
  Start：永远指向第一个元素的前一个
  node1
  node2

  在遍历链表时，不断将node2交换到start之后的位置
  */
  import java.util.*;
public class ReverseLinkedList {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode start = dummy;
        ListNode node1 = null;
        ListNode node2 = null;
        
        for(int i=0;i<n;i++){
            if(i<m-1){
                start = start.next;
            }else if(i == m-1){
                node1 = start.next;
                node2 = node1.next;
            }else{
                node1.next = node2.next;
                node2.next = start.next;
                start.next = node2;
                node2 = node1.next;
            }
        }
       
        return dummy.next;
    }
}