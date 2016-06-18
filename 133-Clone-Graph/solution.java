/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, root);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode> ();
        // Add the nodes
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode cur : queue.poll().neighbors){
                if(!map.containsKey(cur)){
                    map.put(cur, new UndirectedGraphNode(cur.label));
                    queue.offer(cur);
                }
            }
        }
        // Build the edges
        for(UndirectedGraphNode key : map.keySet()){
            for(UndirectedGraphNode n : key.neighbors){
                map.get(key).add(n);
            }
        }
        return map.get(node);
    }
}