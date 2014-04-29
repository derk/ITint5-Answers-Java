/*
树结点的定义(请不要在代码中定义该结构)
public class TreeNode {
  TreeNode left;
  TreeNode right;
}*/
import java.util.*;

public class IsBalancedTree {
    public boolean isBalancedTree(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        
        return isBalancedTree(root, map);
    }
    private static boolean isBalancedTree(TreeNode root, 
                                          Map<TreeNode, Integer> map) {
        if(root == null) {
            return true;
        }
        if(root.left == null && root.right == null) {
            map.put(root, 1);
            return true;
        }
        int hl = 0; //left height
        int hr = 0; //right height
        if(root.left != null){
            if(!isBalancedTree(root.left, map)) {
                return false;
            }
            hl = map.get(root.left);
        }
        if(root.right != null) {
            if(!isBalancedTree(root.right, map)) {
                return false;
            }
            hr = map.get(root.right);
        }
        int h = Math.max(hl, hr) + 1;
        map.put(root, h);
        if(Math.abs(hl - hr) > 1) {
            return false;
        }
        
        return true;
    }
}
