public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int j = 0;
        int win = nums.length + 1;
        for(int i = 0; i < nums.length; i++){
            while(j < nums.length && sum < s){
                sum += nums[j];
                j++;
            }
            if(sum >= s){
                win = Math.min(win, j - i);
            }
            sum -= nums[i];
        }
        return win == nums.length + 1 ? 0 : win;
    }
}