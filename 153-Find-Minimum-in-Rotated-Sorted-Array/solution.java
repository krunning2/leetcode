public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            if(nums[mid] >= nums[end]){
                start = mid;
            }else{
                end = mid;
            }
        }
        return nums[start] > nums[end] ? nums[end] : nums[start];
    }
}