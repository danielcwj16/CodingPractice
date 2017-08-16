/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Codec {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        Codec ins = new Codec();
        String res = ins.serialize(root);
        System.out.println(res);
        TreeNode node = ins.deserialize(res);
        //System.out.println(node.val);
    }

     public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        buildString(root,sb);
        return sb.toString();
    }
    
    public void buildString(TreeNode root,StringBuilder sb){
        if(root == null)
        {
            sb.append("X").append(".");
            return;
        }
        
        sb.append(root.val).append(".");
        buildString(root.left,sb);
        buildString(root.right,sb);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<String>();
        System.out.println(data);
        String[] array = data.split("\\.");
        //System.out.println(array);
        for(String s : array){
            System.out.println(s);
            nodes.add(s);
        }
        return buildTree(nodes);
    }
    
    public TreeNode buildTree(LinkedList<String> nodes){
        if(nodes.size() == 0)
            return null;
        String val = nodes.poll();

        if(val.equals("X"))
            return null;
        else{
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));