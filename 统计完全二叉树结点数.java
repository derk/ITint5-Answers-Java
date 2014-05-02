//使用TreeNodeUtil.getLeftChildNode(TreeNode)获得左儿子结点
//使用TreeNodeUtil.getRightChildNode(TreeNode)获得右儿子结点
//使用TreeNodeUtil.isNullNode(TreeNode)判断结点是否为空
public class CountCompleteBinayTreeNodes {
    public int countNodes(TreeNode root) {
        if(TreeNodeUtil.isNullNode(root)) {
            return 0;
        }
        TreeNode left=TreeNodeUtil.getLeftChildNode(root);
        int hl=0;
        while(!TreeNodeUtil.isNullNode(left)) {
            left=TreeNodeUtil.getLeftChildNode(left);
            hl++;
        }
        TreeNode right=TreeNodeUtil.getRightChildNode(root);
        int hr=0;
        while(!TreeNodeUtil.isNullNode(right)) {
            right=TreeNodeUtil.getRightChildNode(right);
            hr++;
        }
        if(hl==hr){
            return (1<<(hl+1))-1;
        }else {
            return countNodes(TreeNodeUtil.getLeftChildNode(root))
                +  countNodes(TreeNodeUtil.getRightChildNode(root))
                +  1;
        }
    }
}
