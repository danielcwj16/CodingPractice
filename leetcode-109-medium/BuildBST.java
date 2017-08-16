/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * https://siddontang.gitbooks.io/leetcode-solution/content/tree/convert_sorted_listarray_to_binary_search_tree.html
 * 
 * 用二分法自底向上构造平衡二叉树。利用slow 和fast指针寻找根节点，然后继续处理左半部分和右半部分，分别为左子树和右子树。
 */
public class BuildBST {
    public TreeNode sortedListToBST(ListNode head) {
        if( head == null)
            return null;
        return buildBST(head, null);
    }
    
    public TreeNode buildBST(ListNode start,ListNode end){
        if(start == end)
            return null;
        ListNode slow = start;
        ListNode fast = start;
        while(fast != end && fast.next != end){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        TreeNode left = buildBST(start,slow);
        TreeNode right = buildBST(slow.next,end);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}