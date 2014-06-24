import java.util.*;

/*树结点的定义(请不要在代码中定义该结构)
public class TreeNode {
  public TreeNode left, right;
  public boolean isLeftThread, isRightThread;
}*/
public class ThreadedBinaryTree {
    public void convertToThreadedTree(TreeNode root) {
        TreeNode prev=null;
        TreeNode node=root;
        ArrayDeque<TreeNode> stack=new ArrayDeque<TreeNode>();
        while(node!=null || !stack.isEmpty()) {
            if(node!=null) {
                stack.push(node);
                node=node.left;
            } else {
                node=stack.pop();
                //visit
                if(node.left==null) {
                    node.left=prev;
                    node.isLeftThread=true;
                }
                prev=node;
                node=node.right;
            }
        }
        
        node=root;
        TreeNode next=null;
        while(node!=null || !stack.isEmpty()) {
            if(node!=null){
                stack.push(node);
                node=node.right;
            } else {
                node=stack.pop();
                if(node.right==null) {
                    node.right=next;
                    node.isRightThread=true;
                }
                next=node;
                if(!node.isLeftThread)
                    node=node.left;
                else
                    node=null;
            }
        }
    }
}
