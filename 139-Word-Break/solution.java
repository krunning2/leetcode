public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        int max = getMaxLength(wordDict);
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(j = 0; j < i; i++){
                if(dp[j] && s.substring(j, i)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    private int getMaxLength(Set<String> wordDict){
        int max = 0;
        for(String s : wordDict){
            max = Math.max(s.length(), max);
        }
    }
}