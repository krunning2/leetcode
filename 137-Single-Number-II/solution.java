public class Solution {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for(int n : nums){
            for(int i = 0; i < 32; i++){
                bit[i] += (n >> i) & 1;
            }
        }
        int res = 0;
        for(int i = 0; i < 32; i++){
            if(bit[i] % 3 != 0){
                res += 1<<i;
            }
        }
        return res;
    }
}