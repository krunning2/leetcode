public class Solution {
    public boolean canJump(int[] nums) {
        int next = 0;
        int step = 0;
        for(int i = 0; i < nums.length; i++){
            if(step < i){
                step = next;
                if(step < i) return false;
            }
            next = Math.max(next, nums[i] + i);
        }
        return true;
    }
}