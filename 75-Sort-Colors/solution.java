public class Solution {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1, p = 0;
        while(p <= end){
            if(nums[p] == 0){
                nums[p] = nums[start];
                nums[start] = 0;
                start ++;
                p++;
            }else if(nums[p] == 2){
                nums[p] = nums[end];
                nums[end] = 2;
                end--;
            }else{
                p++;
            }
        }
    }
}