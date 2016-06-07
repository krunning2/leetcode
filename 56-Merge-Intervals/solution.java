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
        Comparator<Interval> c = new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        };
        Collections.sort(intervals, c);
        List<Interval> res = new ArrayList<Interval>();
        Interval pre = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(pre.end < cur.start){
                res.add(pre);
                pre = cur;
            }else{
                pre.end = Math.max(pre.end, cur.end);
            }
        }
        res.add(pre);
        return res;
    }
}