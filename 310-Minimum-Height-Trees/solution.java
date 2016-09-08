public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        if(n <= 0){
            return res;
        }
        if(n == 1){
            res.add(0);
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];
        for(int i = 0; i < edges.length; i++){
            indegree[edges[i][0]] ++;
            indegree[edges[i][1]] ++;
            map.putIfAbsent(edges[i][0], new ArrayList<>());
            map.putIfAbsent(edges[i][1], new ArrayList<>());
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 1){
                queue.offer(i);
            }
        }
        while(n > 2){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                for(int node : map.get(cur)){
                    indegree[node] --;
                    if(indegree[node] == 1){
                        queue.offer(node);
                    }
                }
                n--;
            }
        }
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }
}