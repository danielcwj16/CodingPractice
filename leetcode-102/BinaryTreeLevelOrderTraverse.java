/*
经典基础的使用BFS遍历二叉树，注意line 40，不要忘记
 */

import java.util.*;

public class BinaryTreeLevelOrderTraverse{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        ArrayList<Integer> list = new ArrayList<Integer>();
        int nextlevel = 0;
        int count = 1;
        LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
        ll.add(root);
        
        while(ll.size()!=0){
            if(count!=0){
                TreeNode n = ll.poll();
                count--;
                list.add(n.val);
                if(n.left != null)
                {
                    ll.add(n.left);
                    nextlevel++;
                }
                if(n.right!=null)
                {
                    ll.add(n.right);
                    nextlevel++;
                }                   
            }else{
                result.add(new ArrayList<Integer>(list));
                list.clear();
                count = nextlevel;
                nextlevel=0;
            }
        }
        result.add(new ArrayList<Integer>(list));
        return result;
    }
}