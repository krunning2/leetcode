public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null) return;
        int left = 0, right = nums.length - 1, p = 0;
        while(p <= right){
            if(nums[p] == 0){
                nums[p] = nums[left];
                nums[left++] = 0;
                p++;
            }else if(nums[p] == 2){
                nums[p] = nums[right];
                nums[right] = 2;
            }else{
                p++;
            }
        }
    }
}