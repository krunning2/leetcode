public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int p = nums.length - 1;
        while(p > 0){
            if(nums[p - 1] < nums[p]){
                break;
            }
            p--;
        }
        if(p > 0){
            swap(nums, p - 1);
        }
        reverse(nums, p);
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
    
    private void reverse(int[] nums, int p){
        int end = nums.length - 1;
        while(p <= end){
            int tmp = nums[p];
            nums[p] = nums[end];
            nums[end] = tmp;
            p ++;
            end --;
        }
    }
    
}