public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int count = numCourses;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : map.get(cur)){
                if(--indegree[i] == 0){
                    q.offer(i);
                }
            }
            count--;
        }
        return count == 0;
    }
}