public class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    Integer median = null;
    // Adds a number into the data structure.
    public void addNum(int num) {
        if(median == null){
            median = num;
        } else if(median > num){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
        
        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(median);
            median = minHeap.poll();
        }else if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(median);
            median = maxHeap.poll();
        }
        
        // maxHeap.offer(num);
        // minHeap.offer(maxHeap.poll());
        // if(minHeap.size() > maxHeap.size()){
        //     maxHeap.offer(minHeap.poll());
        // }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return median * 1.0;
        }else{
            return (maxHeap.peek() + median) / 2.0;
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();