public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        n = Math.min(10, n);
        dp[0] = 1;
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = 9;
            for(int x = 9; x >= 9 - i + 2; x --){
                dp[i] *= x;
            }
        }
        int res = 0;
        for(int x : dp){
            res += x;
        }
        return res;
    }
}