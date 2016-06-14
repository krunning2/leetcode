public class MedianFinder {
    Comparator<Integer> c = new Comparactor<Integer>(){
        public int compare(Integer a, Integer b){
            return b - a;
        }
    };
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, c);
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    Integer median = null;
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(median == null){
            median = num;
            maxHeap.offer(num);
        }else{
            if(num < median){
                maxHeap.offer(num);
            }else{
                minHeap.offer(num);
            }
            if(minHeap.size() + 1 > maxHeap.size()){
                maxHeap.offer(median);
                median = minHeap.poll();
            }
            if(maxHeap.size() + 1 > minHeap.size()){
                minHeap.offer(median);
                median = maxHeap.poll();
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return median * 1.0;
        }else if(maxHeap.size() > minHeap.size()){
            return (median + maxHeap.peek()) / 2.0;
        }else{
            return (median + minHeap.peek()) / 2.0;
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();