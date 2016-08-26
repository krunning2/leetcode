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
        List<Time> times = new ArrayList<>();
        for(Interval i : intervals){
            times.add(new Time(i.start, true));
            times.add(new Time(i.end, false));
        }
        Collections.sort(times, (t1, t2) -> {
            if(t1.time != t2.time) return t1.time - t2.time;
            return t1.is_start ? 1 : -1;
        });
        int count = 0;
        int max = 0;
        for(int i = 0; i < times.size(); i++){
            Time t = times.get(i);
            if(t.is_start){
                count ++;
            }else{
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
    class Time{
        int time;
        boolean is_start;
        Time(int time, boolean is_start){
            this.time = time;
            this.is_start = is_start;
        }
    }
}