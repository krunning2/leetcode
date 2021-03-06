public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private void quickSort(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int index = partition(nums, l, r);
        quickSort(nums, l, index - 1);
        quickSort(nums, index + 1, r);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k){
        if(start >= end) return nums[start];
        int index = partition(nums, start, end);
        if(index + 1 == k){
            return nums[index];
        }else if(index + 1 < k){
            return quickSelect(nums, index + 1, end, k);
        }else{
            return quickSelect(nums, start, index - 1, k);
        }
    }
    private int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int index = start;
        for(int i = start; i <= end; i++){
            if(nums[i] >= pivot){
                int tmp = nums[index];
                nums[index ++] = nums[i];
                nums[i] = tmp;
            }
        }
        //be be careful of the index position
        return index - 1;
    }
}