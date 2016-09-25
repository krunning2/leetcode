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
    public List<Interval> insert(List<Interval> intervals, Interval pre) {
        List<Interval> res = new ArrayList<Interval>();
        for(Interval cur : intervals){
            if(pre.end < cur.start){
                res.add(pre);
                pre = cur;
            }else if(pre.start > cur.end){
                res.add(cur);
            }else{
                pre.start = Math.min(pre.start, cur.start);
                pre.end = Math.max(pre.end, cur.end);
            }
        }
        res.add(pre);
        return res;
    }
}