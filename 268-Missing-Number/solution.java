public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int s = 0;
        int e = nums.length;
        while(s + 1 < e){
            int m = s - (s - e) / 2;
            if(nums[m] > m){
                e = m;
            }else{
                s = m;
            }
        }
        if(nums[s] > s){
            return s;
        }else if(nums[e] > e){
            return e;
        }else{
            return nums.length;
        }
    }
}