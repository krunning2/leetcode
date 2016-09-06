public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        int max = 0;
        for(int i = 1; i <= s.length(); i++){
            int j = i - dp[i - 1] - 2;
            if(s.charAt(i - 1) == '(' || j < 0 || s.charAt(j) == ')'){
                dp[i] = 0;
            }else{
                dp[i] = dp[i - 1] + 2 + dp[j];
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}