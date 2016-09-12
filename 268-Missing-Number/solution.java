public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        boolean seenZero = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                seenZero = true;
                nums[i] = n + 1;
            }
        }
        if(!seenZero) return 0;
        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            if(index < n)
                nums[index] = -Math.abs(nums[index]);
        }
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                return i + 1;
            }
        }
        return n;
    }
}