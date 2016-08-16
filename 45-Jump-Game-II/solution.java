public class Solution {
    public int jump(int[] nums) {
        int step = 0;
        int next = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            
            if(step < i){
                res ++;
                step = next;
            }
            next = Math.max(next, nums[i] + i);
        }
        return res;
    }
}