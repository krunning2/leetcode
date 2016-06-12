public class Solution {
    public int minPatches(int[] nums, int n) {
        int miss = 1, res = 0;
        int i = 0;
        while( miss <= n){
            if(i < nums.length && nums[i] <= miss){
                res ++;
                miss += nums[i++];
            }else{
                miss += miss;
            }
        }
        return res;
    }
}