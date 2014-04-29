/*
树结点的定义(请不要在代码中定义该类型)
public class TreeNode {
     public int val;
     public List<TreeNode> children; //该结点所有的儿子结点
};
*/
import java.util.*;

public class MaxTreePathSum {
    public int maxTreePathSum(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        calc(root, map);
        IntHolder max = new IntHolder();
        max.val = 0;
        calc2(root, map, max);
        return max.val;
    }
    private static void calc2(TreeNode root, HashMap<TreeNode, Integer> map, 
                              IntHolder max) {
        if(root == null) return;
        if(root.children == null || root.children.size() == 0) {
            max.val = max.val < root.val ? root.val : max.val;
        }
        
        //find biggest 2
        int m1 = 0;
        int m2 = 0;
        for(TreeNode n : root.children) {
            int v = map.get(n);
            if (v > m2) {
                m2 = v;
            }
            if(m1 < m2) {
                int t = m1;
                m1 = m2;
                m2 = t;
            }
        }
        if(max.val < m1 + m2 + root.val) {
            max.val = m1 + m2 + root.val;
        }
        for(TreeNode n : root.children) {
            calc2(n, map, max);
        }
    }
    private static void calc(TreeNode root, HashMap<TreeNode, Integer> map) {
        if(root == null) return;
        if(root.children == null || root.children.size() == 0) {
            map.put(root, root.val);
            return;
        }
        int max = 0;
        for(TreeNode n : root.children) {
            calc(n, map);
            int v = map.get(n);
            max = v > max? v : max;
        }
        map.put(root, root.val + max);
        return;
    }
    private static class IntHolder {
        int val;
    }
}
