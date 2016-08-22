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
        HashMap<Double, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < points.length; i++){
            map.clear();
            int same = 0;
            int local = 1;
            for(int j =  i + 1; j < points.length; j++){
                Point p1 = points[i];
                Point p2 = points[j];
                double slope = 0.0;
                if(p1.x == p2.x && p1.y == p2.y){
                    same ++;
                    continue;
                }else if(p1.x == p2.x){
                    slope = Double.MAX_VALUE;
                }else if(p1.y == p2.y){
                    slope = 0.0;    
                }else{
                    slope = (p1.y - p2.y) * 1.0 / (p1.x - p2.x);
                }
                if(map.containsKey(slope)){
                    map.put(slope, map.get(slope) + 1);
                }else{
                    map.put(slope, 2);
                }
                local = Math.max(local, map.get(slope));
            }
            res = Math.max(local + same, res);
        }
        return res;
    }
}