public class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length == 0){
            return true;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int i = 0; i < points.length; i++){
            max = Math.max(max, points[i][0]);
            min = Math.min(min, points[i][0]);
            map.putIfAbsent(points[i][0], new HashSet<Integer>());
            map.get(points[i][0]).add(points[i][1]);
        }
        int sum =(max + min);
        for(int i = 0; i < points.length; i++){
            int curX = points[i][0];
            int curY = points[i][1];
            int targetX = sum - curX;
            if(map.containsKey(targetX) && map.get(targetX).contains(curY)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}