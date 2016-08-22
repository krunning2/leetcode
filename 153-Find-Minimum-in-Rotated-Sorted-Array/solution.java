public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            min = Math.min(min, nums[mid]);
            if(nums[mid] > nums[end]){
                start = mid;
            }else{
                 end = mid;   
            }
        }
        min = Math.min(min, Math.min(nums[start], nums[end]));
        return min;
    }
}