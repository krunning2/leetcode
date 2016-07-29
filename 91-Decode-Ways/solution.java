public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        if(n == 1) return check1(s.charAt(0));
        int[] dp = new int[n];
        dp[0] = check1(s.charAt(0));
        
        for(int i = 1; i < n; i++){
            int first = Integer.parseInt(s.substring(i, i + 1));
            int second = Integer.parseInt(s.substring(i - 1, i + 1));
            if(first >= 1 && first <= 9){
                dp[i] = dp[i - 1];
            }
            if(second >= 10 && second <= 26){
                if(i > 1){
                    dp[i] += dp[i - 2];
                }else{
                    dp[i] += 1; 
                }
            }
        }
        return dp[n - 1];
    }
    private int check1(char c){
        return c == '0' ? 0 : 1;
    }
    
}