public class Solution {
    public boolean canJump(int[] nums) {
        int next = 0;
        int dis = 0;
        for(int i = 0; i < nums.length; i++){
            if(dis < i){
                dis = next;
                if(dis < i){
                    return false;
                }
            }
            next = Math.max(next, nums[i] + i);
        }
        return true;
    }
}