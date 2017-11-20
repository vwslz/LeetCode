import java.util.HashMap;

public class CloneGraph_133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;

        HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        return cloneGraphHelper(node, map);
    }

    public UndirectedGraphNode cloneGraphHelper(UndirectedGraphNode ori, HashMap<Integer, UndirectedGraphNode> map) {
        if (map.containsKey(ori.label))
            return map.get(ori.label);

        UndirectedGraphNode newNode = new UndirectedGraphNode(ori.label);
        map.put(ori.label, newNode);
        for (UndirectedGraphNode neighbor: ori.neighbors)
            newNode.neighbors.add(cloneGraphHelper(neighbor, map));
        return newNode;
    }
}
