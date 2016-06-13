public class MovingAverage {
    int size;
    long sum;
    Deque<Integer> queue;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        queue = new Deque<Integer>();
    }
    
    public double next(int val) {
        sum += val;
        queue.addLast(val);
        if(queue.size() > size){
            sum -= queue.removeLast();
        }
        return sum * 1.0 / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */