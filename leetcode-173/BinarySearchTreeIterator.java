/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

/*
最基本的二叉树的Inorder Traverse题，查找最小值
*/

import java.util.*;
public class BinarySearchTreeIterator{
    List<Integer> tree;
    int idx;
    public BinarySearchTreeIterator(TreeNode root) {
        tree = new ArrayList<Integer>();
        InOrderTraverse(root,tree);
        idx = 0;
    }

    private void InOrderTraverse(TreeNode node,List<Integer> tree){
        if(node == null){
            return;
        }
        InOrderTraverse(node.left,tree);
        tree.add(node.val);
        InOrderTraverse(node.right,tree);
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return idx<tree.size() ? true : false;
    }

    /** @return the next smallest number */
    public int next() {
        return tree.get(idx++);
    } 
}