public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}