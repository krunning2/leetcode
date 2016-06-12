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
            list.add(new Pair(i.end, false));
        }
        Collections.sort(list, new Comparator<Pair>(){
            public int compare(Pair i1, Pair i2){
                if(i1.t == i2.t){
                    return i1.is_start ? 1 : -1;
                } else {
                    return i1.t - i2.t;
                }
            }
        });
        int count = 0;
        int max = 0;
        for(Pair p : list){
            if(p.is_start){
                count++;
            }else{
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
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