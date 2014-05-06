import java.util.*;

public class CloneGraph {
    public GraphNode cloneGraph(GraphNode node) {
        if(node==null) return null;
        //dfs and add cloned node to it's neighbors
        HashSet<GraphNode> set = new HashSet<GraphNode>();
        dfs(node, set);
        //dfs again to setup the cloned nodes neighbors
        set.clear();
        dfs2(node, set);
        
        GraphNode newNode = node.neighbors.get(node.neighbors.size()-1);
        
        //dfs3 to remove the cloned node from the neighbors list
        //optional if we can change node's structure
        set.clear();
        dfs3(node, set);
        
        return newNode;
    }
    private static void dfs(GraphNode node, HashSet<GraphNode> set) {
        if(node==null) return;
        if(set.contains(node)) return;
        set.add(node);
        for(GraphNode n : node.neighbors) {
            dfs(n, set);
        }
        node.neighbors.add(new GraphNode(node.data));
    }
    private static void dfs2(GraphNode node, HashSet<GraphNode> set) {
        if(node==null) return;
        if(set.contains(node)) return;
        set.add(node);
        GraphNode newNode = node.neighbors.get(node.neighbors.size()-1);
        for(int i = 0; i < node.neighbors.size()-1; i++) {
            GraphNode n = node.neighbors.get(i);
            newNode.neighbors.add(n.neighbors.get(n.neighbors.size()-1));
            dfs2(n, set);
        }
    }
    private static void dfs3(GraphNode node, HashSet<GraphNode> set) {
        if(node==null) return;
        if(set.contains(node)) return;
        set.add(node);
        node.neighbors.remove(node.neighbors.size()-1);
        for(int i = 0; i < node.neighbors.size()-1; i++) {
            GraphNode n = node.neighbors.get(i);
            dfs3(n, set);
        }
    }
}


/*
import java.util.*;

public class CloneGraph {
    public GraphNode cloneGraph(GraphNode node) {
        //use two ArrayLists
        if(node==null) return null;
        ArrayList<GraphNode> oldList = new ArrayList<GraphNode>();
        ArrayList<GraphNode> newList = new ArrayList<GraphNode>();
        return cloneGraph(node, oldList, newList);
    }
    private static GraphNode cloneGraph(GraphNode node, 
                                        ArrayList<GraphNode> oldList,
                                        ArrayList<GraphNode> newList) {
        oldList.add(node);
        GraphNode newNode = new GraphNode(node.data);
        newList.add(newNode);
        for(GraphNode n : node.neighbors) {
            int index = oldList.indexOf(n);
            if(index<0) {
                newNode.neighbors.add(cloneGraph(n, oldList, newList));
            } else {
                newNode.neighbors.add(newList.get(index));
            }
        }
        return newNode;
    }
}
*/
