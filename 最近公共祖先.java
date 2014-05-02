public class LCA {
    //返回结点node1和node2的最近公共祖先
    public TreeNode getLCA(TreeNode node1, TreeNode node2) {   
        if(node1==null || node2==null) {
            return null;
        }
        int h1=0;
        TreeNode t1=node1;
        while(t1.parent!=null) {
            t1=t1.parent;
            h1++;
        }
        int h2=0;
        TreeNode t2=node2;
        while(t2.parent!=null) {
            t2=t2.parent;
            h2++;
        }
        if(h1>h2) {
            int delta = h1-h2;
            while(delta-->0) {
                node1=node1.parent;
            }
        }
        if(h2>h1) {
            int delta = h2-h1;
            while(delta-->0) {
                node2=node2.parent;
            }
        }
        while(node1!=node2){
            node1=node1.parent;
            node2=node2.parent;
        }
        return node1;
    }
}
