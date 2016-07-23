public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int l, int r, int k){
        if(l >= r) return nums[l];
        int index = partition(nums, l, r);
        if(index + 1 == k){
            return nums[index];
        }else if(index + 1 < k){
            return quickSelect(nums, index + 1, r, k);
        }else {
            return quickSelect(nums, l, index, k);
        }
    }
    
    //descending order
    private int partition(int[] nums, int l, int r){
        int pivot = nums[r];
        int index = l;
        for(int i = l; i < r; i++){
            if(nums[i] >= pivot){
                int tmp = nums[index];
                nums[index++] = nums[i];
                nums[i] = tmp;
            }
        }
        int tmp = nums[index];
        nums[index] = nums[r];
        nums[r] = tmp;
        return index;
    }
}