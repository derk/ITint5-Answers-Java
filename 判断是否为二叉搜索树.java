/*
树结点的定义(请不要在代码中定义该结构)
public class TreeNode {
  int val;
  TreeNode left, right;
}*/
public class IsBinarySearchTree {
    public boolean isBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        if(!isBST(root.left)) {
            return false;
        }
        if(!isBST(root.right)) {
            return false;
        }
        TreeNode l = root.left;
        if(l != null) {
            while(l.right != null) {
                l = l.right;
            }    
            if(root.val < l.val) {
                return false;
            }
        }
        TreeNode r = root.right;
        if(r != null) {
            while(r.left != null) {
                r = r.left;
            }
            if(root.val >= r.val) {
                return false;
            }
        }
        return true;
    }
}
