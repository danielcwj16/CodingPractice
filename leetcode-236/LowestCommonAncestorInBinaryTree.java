/**
 * 该题可以用递归的方法也可以遍历,找到p和q的parent，将p的ancesctor放入list，然后遍历q的ancestor，找到第一个相同的ancestor
 */
public class LowestCommonAncestorInBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}