public class Solution {
    public boolean canWinNim(int n) {
        if(n <= 3) return true;
        if(n >= 100){
            return n % 4 != 0;
        }
        boolean[] dp = new boolean[3];
        dp[0] = true;
        dp[1] = true;
        dp[2] = true;
        for(int i = 3; i < n; i++){
            dp[i % 3] = !dp[(i - 1) % 3] || !dp[(i - 2) % 3] || !dp[(i - 3) % 3];
        }
        return dp[(n - 1) % 3];
    }
}