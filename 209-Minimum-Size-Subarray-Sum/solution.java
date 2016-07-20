public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int left = 0, right = 0, len = nums.length, res = nums.length + 1;
        while(right < len){
            while(right < len && sum < s){
                sum += nums[right ++];
            }
            while(sum >= s){
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }
        return res == nums.length + 1 ? 0 : res;
    }
}