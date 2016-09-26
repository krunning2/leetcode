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
        if(points == null || points.length == 0){
            return 0;
        }
        Map<String, Integer> map = new HashMap<>();
        int res = 1;
        for(int i = 0; i < points.length; i++){
            int same = 0;
            int localMax = 1;
            map.clear();
            for(int j = i + 1; j < points.length; j++){
                int x = points[i].x - points[j].x;
                int y = points[i].y - points[j].y;
                if(x == 0 && y == 0){
                    same++;
                    continue;
                }
                int gcd = getGCD(x, y);
                x /= gcd;
                y /= gcd;
                String slope = String.valueOf(x) + String.valueOf(y);
                
                if(map.containsKey(slope)){
                    map.put(slope, map.get(slope) + 1);
                }else{
                    map.put(slope, 2);
                }
                localMax = Math.max(localMax, map.get(slope));
            }
            res = Math.max(res, localMax + same);
        }
        return res;
    }
    private int getGCD(int a, int b){
        return b == 0 ? a : getGCD(b, a % b);
    }
}