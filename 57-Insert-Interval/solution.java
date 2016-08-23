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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        for(Interval cur : intervals){
            if(newInterval.start > cur.end){
                res.add(cur);
            }else if(newInterval.end < cur.start){
                res.add(newInterval);
                newInterval = cur;
            }else{
                newInterval.start = Math.min(newInterval.start, cur.start);
                newInterval.end = Math.max(newInterval.end, cur.end);
            }
        }
        res.add(newInterval);
        return res;
    }
}