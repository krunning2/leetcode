public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        if(n == 1) return check1(s.charAt(0));
        int[] dp = new int[n];
        dp[0] = check1(s.charAt(0));
        dp[1] = dp[0] + check2(s.charAt(0), s.charAt(1));
        for(int i = 2; i < n; i++){
            if(check1(s.charAt(i)) == 1) dp[i] = dp[i - 1];
            if(check2(s.charAt(i-1),s.charAt(i))==1) dp[i] += dp[i - 2];
        }
        return dp[n - 1];
    }
    private int check1(char c){
        return c == '0' : 0 : 1;
    }
    private int check2(char c1, char c2){
        return c1 == '1' || c1 == '2' && c2 <= '6' ? 1 : 0;
    }
}