public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        if(n == 1) return check1(s.charAt(0));
        int[] dp = new int[3];
        dp[0] = check1(s.charAt(0));
        
        for(int i = 1; i < n; i++){
            int first = Integer.parseInt(s.substring(i, i + 1));
            int second = Integer.parseInt(s.substring(i - 1, i + 1));
            dp[i % 3] = 0;
            if(first >= 1 && first <= 9){
                dp[i % 3] = dp[(i - 1) % 3];
            }
            if(second >= 10 && second <= 26){
                if(i > 1){
                    dp[i % 3] += dp[(i - 2) % 3];
                }else{
                    dp[i % 3] += 1; 
                }
            }
        }
        return dp[(n - 1) % 3];
    }
    private int check1(char c){
        return c == '0' ? 0 : 1;
    }
    
}