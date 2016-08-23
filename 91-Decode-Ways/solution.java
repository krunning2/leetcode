public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] dp = new int[3];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        if(s.length() == 1){
            return dp[0];
        }
        for(int i = 1; i < s.length(); i++){
            int one = Integer.valueOf(s.substring(i, i + 1));
            int two = Integer.valueOf(s.substring(i - 1, i + 1));
            dp[i % 3] = 0;
            if(one >= 1 && one <= 9){
                dp[i % 3] += dp[(i - 1) % 3];
            }
            if(two >= 10 && two <= 26){
                if(i == 1){
                    dp[i % 3] += 1;
                }else{
                    dp[i % 3] += dp[(i - 2) % 3];
                }
            }
        }
        return dp[(s.length() - 1) % 3];
    }
}