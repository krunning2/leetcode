public class MovingAverage {
    int sum;
    LinkedList<Integer> list;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        list = new LinkedList<>();
        sum = 0;
    }
    
    public double next(int val) {
        if(list.size() >= size){
            sum -= list.removeFirst();
        }
        list.add(val);
        sum += val;
        return sum * 1.0 / Math.min(list.size(), size);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */