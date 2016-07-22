public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) return 0;
        return find(nums, 0, nums.length - 1, k);
    }
    
    private int find(int[] nums, int left, int right, int k){
        if(left <= right){
            return nums[left];
        }
        int index = partition(nums, left, right, k);
        if(index + 1 == k){
            return nums[index];
        } else if(index + 1 < k){
            return find(nums, index + 1, right, k);
        }else{
            return find(nums, left, index - 1, k);
        }
    }
    private int partition(int[] nums, int left, int right){
        int pivot = nums[right];
        int index = left;
        for(int i = left; i < right; i ++){
            if(nums[i] >= pivot){
                int tmp = nums[index];
                nums[index++] = nums[i];
                nums[i] = tmp;
            }
        }
        int tmp = nums[index];
        nums[index] = nums[right];
        nums[right] = tmp;
        return index;
    }
}