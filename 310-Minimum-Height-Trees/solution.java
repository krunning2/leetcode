public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n <= 0) return res;
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < edges.length; i++){
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
            graph.putIfAbsent(edges[i][0], new ArrayList<Integer>());
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int x : indegree){
            if(x == 1){
                queue.offer(x);
            }
        }
        while(n > 2){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                for(int x : graph.get(cur)){
                    indegree[x] --;
                    if(indegree[x] == 1) {
                        queue.offer(x);
                        n--;
                    }
                }
            }
        }
        while(!queue.isEmpty()) res.add(queue.poll());
        return res;
    }
}