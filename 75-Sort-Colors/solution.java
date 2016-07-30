public class Solution {
    public void sortColors(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int p = 0;
        while(p <= e){
            if(nums[p] == 1){
                p++;
                continue;
            }else if(nums[p] == 0){
                nums[p] = nums[s];
                nums[s] = 0;
                s++;
                p++;
            }else{
                nums[p] = nums[e];
                nums[e] = 2;
                e--;
            }
        }
    }
}