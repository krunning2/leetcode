public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        Interval cur = intervals.get(0);
        List<Interval> res = new ArrayList<Interval>();
        for(int i = 1; i < intervals.size(); i++){
            Interval n = intervals.get(i);
            if(cur.end >= n.start){
                cur.end = Math.max(cur.end, n.end);
            }else{
                res.add(cur);
                cur = n;
            }
        }
        res.add(cur);
        return res;
    }
}