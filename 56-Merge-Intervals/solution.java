/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1){
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        Interval cur = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            if(cur.end < intervals.get(i).start){
                res.add(cur);
                cur = intervals.get(i);
            }else{
                cur.start = Math.min(cur.start, intervals.get(i).start);                
                cur.end = Math.max(cur.end, intervals.get(i).end);                
            }
        }
        res.add(cur);
        return res;
    }
}