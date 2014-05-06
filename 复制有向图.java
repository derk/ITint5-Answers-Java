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
