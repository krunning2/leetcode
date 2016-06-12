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
    public int minMeetingRooms(Interval[] intervals) {
        List<Pair> list = new ArrayList<Pair>();
        for(Interval i : intervals){
            list.add(new Pair(i.start, true));
            list.add(i.end, false);
        }
        Arrays.sort(list, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.t - i2.t;
            }
        });
        int count = 0;
        for(Pair p : list){
            if(p.is_start){
                count++;
            }else{
                count--;
            }
        }
        return count;
    }
    class Pair{
        int t;
        boolean is_start;
        Pair(int t, boolean is_start){
            this.t = t;
            this.is_start = is_start;
        }
    }
}