public class PhoneDirectory {
    int counter;
    int max;
    LinkedList<Integer> recycledNumber;
    Set<Integer> usedNumber;
    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        recycledNumber = new LinkedList<>();
        usedNumber = new HashSet<>();
        counter = 0;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(recycledNumber.size() == 0 && counter >= max){
            return -1;
        }
        if(recycledNumber.size() == 0){
            usedNumber.add(counter);
            return counter ++;
        }else{
            int removed = recycledNumber.removeFirst();
            usedNumber.add(removed);
            return removed;
        }
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !usedNumber.contains(number) && number < max;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        if(usedNumber.contains(number)){
            usedNumber.remove(number);
            recycledNumber.addLast(number);
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