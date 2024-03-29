/**
 * The thief has found himself a new place for his thievery again. 
 * There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. 
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \ 
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \ 
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.
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
  * 用递归DFS，我们可以利用回溯法来做，因为当前的计算需要依赖之前的结果，那么我们对于某一个节点，如果其左子节点存在，
  我们通过递归调用函数，算出不包含左子节点返回的值，同理，如果右子节点存在，算出不包含右子节点返回的值，
  那么此节点的最大值可能有两种情况，一种是该节点值加上不包含左子节点和右子节点的返回值之和，另一种是左右子节点返回值之和不包含当期节点值，取两者的较大值返回即可。

  用Hashmap记录已经计算过的节点。
  */
class HouseRobber {
    public int rob(TreeNode root) {
        if(root == null) return 0;

        int val = 0;
        if(root.left != null){
            val += rob(root.left.left) + rob(root.left.right);
        }
        if(root.right != null){
            val += rob(root.right.left) + rob(root.right.right);
        }

        return Math.max(root.val+val, rob(root.left)+rob(root.right));
    }

    public int[] dfs(TreeNode root){
        if(root == nul) return new int[2];

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] res = new int[2];
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return res;
    }
}