public class Solution {
    public int findPeakElement(int[] nums) {
        int s = 0, e = nums.length - 1;
        while(s + 1 < e){
            int m = s - (s - e) / 2;
            if(nums[m] > nums[m - 1] && nums[m] > nums[m + 1]){
                return m;
            }
            if(nums[m] < nums[m + 1]){
                s = m;
            }else if(nums[m] > nums[m + 1]){
                e = m;
            }
        }
        return nums[s] > nums[e] ? s : e;
    }
}