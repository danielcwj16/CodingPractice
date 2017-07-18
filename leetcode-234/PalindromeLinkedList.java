    /**
     * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
     */


/* Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * 
 */

/**
 * 运用stack栈来reverse 链表的顺序，stack先进后出的特性
 */
import java.util.*;
    public class PalindromeLinkedList {
        public boolean isPalindrome(ListNode head){
                if(head == null || head.next == null)
                    return true;
                ListNode p1 = head;
                ListNode p2 = head;
                Stack<Integer> stack = new Stack<Integer>();

                stack.push(p1.val);
                while(p2.next !=null && p2.next.next != null){
                    p1 = p1.next;
                    p2 = p2.next.next;
                    stack.push(p1.val);
                }
                if(p2.next == null){
                    stack.pop();
                }
                while(p1.next != null){
                    p1 = p1.next;
                    int temp = stack.peek();
                    stack.pop();
                    if(temp != p1.val)
                        return false;
                }
                return true;
        }
    }