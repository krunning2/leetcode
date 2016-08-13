public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>> ();
        if(s == null || s.length() == 0) return res;
        boolean[][] dp = get(s);
        helper(res, s, 0, new ArrayList<>(), dp);
        return res;
    }
    
    private void helper(List<List<String>> res, String s, int start, List<String> cur, boolean[][] dp){
        if(start == s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start; i < s.length(); i++){
            if(dp[start][i]){
                cur.add(s.substring(start, i + 1));
                helper(res, s, i + 1, cur, dp);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private boolean[][] get(String s){
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        for(int i = 1; i < len; i++){
            for(int j = 0; j + i < len; j++){
                if(s.charAt(j) == s.charAt(j + i) && (i == 1 || dp[j + 1][j + i - 1])){
                    dp[j][j + i] = true;
                }
            }
        }
        return dp;
    }
}