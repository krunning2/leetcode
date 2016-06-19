public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int indegree[] = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<Integer>());
        }
        for(int i = 0; i < prerequisites.length; i++){
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        int[] res = new int[numCourses];
        int p = 0;
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
                res[p++] = i;
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : map.get(cur)){
                if(--indegree[i] == 0){
                    res[p++] = i;
                    q.offer(i);
                }
            }
        }
        return p == numCourses ? res : new int[0];
    }
}