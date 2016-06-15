public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k <= 0){
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            while(!deque.isEmpty() && deque.peekLast() < nums[i]){
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