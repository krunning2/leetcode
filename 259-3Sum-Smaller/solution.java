public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        Arrays.sort(nums);
        int counter = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int cur = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(nums[start] + nums[end] + cur >= target){
                    end--;
                }else{
                    counter += end - start;
                    start++;
                }
            }
        }
        return counter;
    }
}