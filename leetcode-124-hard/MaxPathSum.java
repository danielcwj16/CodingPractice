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
 * 首先我们分析一下对于指定某个节点为根时，最大的路径和有可能是哪些情况。
 * 第一种是左子树的路径加上当前节点，
 * 第二种是右子树的路径加上当前节点，
 * 第三种是左右子树的路径加上当前节点（相当于一条横跨当前节点的路径），
 * 第四种是只有自己的路径。
 * 乍一看似乎以此为条件进行自下而上递归就行了，然而这四种情况只是用来计算以当前节点根的最大路径，如果当前节点上面还有节点，那它的父节点是不能累加第三种情况的。所以我们要计算两个最大值，一个是当前节点下最大路径和，另一个是如果要连接父节点时最大的路径和。我们用前者更新全局最大量，用后者返回递归值就行了。
 * https://segmentfault.com/a/1190000003554858
 */
public class maxPathSum {
    private int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        
        helper(root);
        
        return max;
    }
    
    public int helper(TreeNode root)
        if(root == null)
            return 0;
    
        int left = helper(root.left);
        int right = helper(root.right);
    
        int sum = Math.max(Math.max(left+root.val,right+root.val),root.val);
         max = Math.max(left+right+root.val,sum);
    return sum;
    }
}