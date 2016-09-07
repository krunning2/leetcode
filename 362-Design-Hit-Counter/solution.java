public class HitCounter {
    Tuple[] tuples;
    /** Initialize your data structure here. */
    public HitCounter() {
        tuples = new Tuple[300];
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if(tuples[index] == null || tuples[index].ts != timestamp){
            tuples[index] = new Tuple(1, timestamp);
        }else {
            tuples[index].counter++;
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int res = 0;
        for(int i = 0; i < 300; i++){
            res += tuples[i] != null && timestamp - tuples[i].ts < 300 ? tuples[i].counter : 0;
        }
        return res;
    }
    class Tuple{
        int counter;
        int ts;
        Tuple(int counter, int ts){
            this.ts = ts;
            this.counter = counter;
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */