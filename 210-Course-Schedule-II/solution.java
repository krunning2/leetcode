public class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        int[] res = new int[numCourses];
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i < pre.length; i++){
            map.get(pre[i][1]).add(pre[i][0]);
            indegree[pre[i][0]]++;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                res[count++] = i;
            }
        }
        while(! queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                for(int n : map.get(cur)){
                    indegree[n]--;
                    if(indegree[n] == 0){
                        res[count++] = n;
                        queue.offer(n);
                    }
                }
            }
        }
        return count == numCourses ? res : new int[]{};
    }
}