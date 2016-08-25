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
        if(node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                UndirectedGraphNode cur = queue.poll();
                for(UndirectedGraphNode nei : cur.neighbors){
                    if(!map.containsKey(nei)){
                        map.put(nei, new UndirectedGraphNode(nei.label));
                        queue.offer(nei);
                    }
                }
            }
        }
        for(Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry : map.entrySet()){
            for(UndirectedGraphNode nei : entry.getKey().neighbors){
                entry.getValue().neighbors.add(map.get(nei));
            }
        }
        return newNode;
    }
}