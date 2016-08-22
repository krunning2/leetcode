public class Solution {
    public int maxProduct(int[] nums) {
        int min = 1;
        int max = 1;
        int res = Integer.MIN_VALUE;
        for(int n : nums){
            if(n == 0){
                min = 0;
                max = 0;
            }else if(n > 0){
                int tmp = max;
                max = Math.max(n, max * n);
                min = Math.min(n, min * n);
            }else{
                int tmp = max;
                max = Math.max(n, min * n);
                min = Math.min(n, tmp * n);
            }
            res = Math.max(max, res);
        }
        return res;
    }
}