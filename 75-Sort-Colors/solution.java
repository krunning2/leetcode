public class Solution {
    public void sortColors(int[] nums) {
        int p1 = 0, start = 0, p2 = nums.length - 1;
        while(p1 <= p2){
            if(nums[p1] == 0){
                nums[p1++] = nums[start];
                nums[start++] = 0;
            }else if(nums[p1] == 1){
                p1 ++;
            }else{
                nums[p1] = nums[p2];
                nums[p2--] = 2;
            }
        }
    }
}