public class PhoneDirectory {

    Queue<Integer> queue;
    Set<Integer> set;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        queue = new LinkedList<Integer>();
        for(int i = 0; i < maxNumbers; i++){
            queue.offer(i);
        }
        set = new HashSet<Integer>();
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(queue.isEmpty()){
            return -1;
        }
        int res = queue.poll();
        set.add(res);
        return res;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !set.contains(number);
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(set.contains(number)){
            set.remove(number);
            queue.offer(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */