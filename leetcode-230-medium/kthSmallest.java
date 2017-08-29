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
 * 中序遍历可以比较简单的解答。
 * TIme： O（k）
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(!s.isEmpty() || p != null){
            if(p != null){
                s.push(p);
                p = p.left;
            }else{
                p = s.pop();
                k--;
                if( k ==0){
                    return p.val;
                }
                p = p.right;
            }
        }
        
        return -1;
    }
}