public class Solution {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < 32; j++){
                bit[j] += nums[i] >> j & 1;
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            if(bit[i] % 3 != 0){
                res += 1 << i;
            }
        }
        return res;
    }
}