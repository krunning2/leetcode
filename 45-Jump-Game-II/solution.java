public class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int maxStep = 0;
        int cur = 0;
        for(int i = 0; i < nums.length; i++){
            if(cur < i){
                cur = maxStep;
                step++;
            }
            maxStep = Math.max(maxStep, nums[i] + i);
        }
        return step;
    }
}