/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        HashMap<Double, Integer> map = new HashMap();
        int max = 0;
        for(int i = 0; i < points.length; i++){
            map.clear();
            int samePoint = 0;
            Point p1 = points[i];
            int curMax = 1;
            for(int j = i + 1; j < points.length; j++){
                double k = 0.0;
                Point p2 = points[j];
                if(p2.x == p1.x && p2.y == p1.y){
                    samePoint ++;
                    continue;
                }else if(p2.y == p1.y){
                    k = 0.0;
                }else if(p2.x == p1.x){
                    k = Double.MAX_VALUE;
                }else{
                    k = (p1.y - p2.y) * 1.0 / (p1.x - p2.x);
                }
                if(map.containsKey(k)){
                    map.put(k , map.get(k) + 1);
                }else{
                    map.put(k, 2);
                }
                curMax = Math.max(curMax, map.get(k));
            }
            max = Math.max(max, curMax + samePoint);
        }
        return max;
    }
}