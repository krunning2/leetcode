public class Solution {
    public int[] singleNumber(int[] nums) {
        int x1XorX2 = 0;
        for(int n : nums){
            x1XorX2 ^= n;
        }
        int lowBit = x1XorX2 & -x1XorX2;
        int res1 = 0;
        int res2 = 0;
        for(int n : nums){
            if((lowBit & n) == 0){
                res1 ^= n;
            }else{
                res2 ^= n;
            }
        }
        return new int[] {res1, res2};
    }
}