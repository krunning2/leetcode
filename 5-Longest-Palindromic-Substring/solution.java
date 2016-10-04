public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        String res = "";
        int max = 0;
        for(int len = 1; len < s.length(); len++){
            for(int start = 0; start + len < s.length(); start++){
                if(s.charAt(start) == s.charAt(start + len) &&( len == 1 || dp[start + 1][start + len - 1])){
                    dp[start][start + len] = true;
                    if(max < len + 1){
                        max = len + 1;
                        res = s.substring(start, start + len + 1);
                    }
                }
            }
        }
        return res;
    }
}