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
        Map<Long, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < points.length; i++){
            int same = 0;
            int localMax = 1;
            map.clear();
            for(int j = i + 1; j < points.length; j++){
                Point cur = points[i];
                Point next = points[j];
                if(cur.x == next.x && cur.y == next.y){
                    same++;
                }else{
                    int gcd = getGCD(cur.y - next.y, cur.x - next.x);
                    int x = (cur.x - next.x) / gcd;
                    int y = (cur.y - next.y) / gcd;
                    long key = ((long)x) << 32 | y;
                    if(map.containsKey(key)){
                        map.put(key, map.get(key) + 1);
                    }else{
                        map.put(key, 2);
                    }
                    localMax = Math.max(localMax, map.get(key));
                }
            }
            max = Math.max(max, same + localMax);
        }
        return max;
    }
    private int getGCD(int a, int b){
        return b == 0 ? a : getGCD(b, a % b);
    }
}