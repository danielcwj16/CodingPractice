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
 * DFS的pre order或者post order都可以解
 */
class FlattenBinaryTree {
    TreeNode pre = new TreeNode(0);
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        pre.right = root;
        pre = root;
        flatten(left);
        flatten(right);
      //buildList(root);
        return;
    }
    
    public void buildList(TreeNode root){
        if(root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        pre.right = root;
        pre = root;
        if(left!=null)
            buildList(left);
        if(right != null)
            buildList(right);
    }
}