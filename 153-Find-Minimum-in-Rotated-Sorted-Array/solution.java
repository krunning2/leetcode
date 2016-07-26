public class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        while(s + 1 < e){
            int m = s - (s - e) / 2;
            if(nums[m] > nums[e]){
                s = m;
            }else{
                e = m;
            }
        }
        return Math.min(nums[s], nums[e]);
    }
}