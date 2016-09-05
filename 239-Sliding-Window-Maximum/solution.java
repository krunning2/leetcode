public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 1){
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
            while(!deque.isEmpty() && nums[i] > deque.peekLast()){
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            if(i - k >= 0 && nums[i - k] == deque.peekFirst()){
                deque.pollFirst();
            }
            if(i + 1 >= k){
                res[i - k + 1] = deque.peekFirst();
            }
        }
        return res;
    }
}