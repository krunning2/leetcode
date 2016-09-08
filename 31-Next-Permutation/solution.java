public class Solution {
    public void nextPermutation(int[] nums) {
        int p = nums.length - 1;
        while(p > 0 && nums[p] <= nums[p - 1]){
            p--;
        }
        if(p == 0){
            reverse(nums, 0, nums.length - 1);
        }else{
            swap(nums, p - 1);
            reverse(nums, p, nums.length - 1);
        }
    }
    
    
    private void swap(int[] nums, int p){
        int end = nums.length - 1;
        while(end > p){
            if(nums[end] > nums[p]){
                break;
            }
            end --;
        }
        int tmp = nums[end];
        nums[end] = nums[p];
        nums[p] = tmp;
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start <= end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}