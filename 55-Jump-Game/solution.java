public class Solution {
    public boolean canJump(int[] nums) {
        int s = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            if(s < i){
                s = max;
                if(s < i){
                    return false;
                }
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }
}