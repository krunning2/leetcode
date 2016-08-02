public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        boolean zero = false;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                nums[i] = n + 1;
                zero = true;
            }
        }
        for(int i = 0; i < n; i++){
            int index = Math.abs(nums[i]) - 1;
            if(index < n)
                nums[index] = -Math.abs(nums[index]);
        }
        if(!zero) return 0;
        for(int i = 0; i < n; i++){
            if(nums[i] >= 0) return i + 1;
        }
        return n;
    }
}