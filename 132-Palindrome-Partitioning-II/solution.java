public class Solution {
    public int minCut(String s) {
        if(s == null) return 0;
        int dp[] = new int[s.length() + 1];
        for(int i = 0; i <= s.length(); i++){
            dp[i] = i - 1;
        }
        boolean[][] matrix = getMatrix(s);
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(matrix[j][i - 1]){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[s.length()];
    }
    private boolean[][] getMatrix(String s){
        boolean[][] m = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            m[i][i] = true;
        }
        // the length is increasing 表示start 加上 的长度，并非总长度。
        for(int len = 1; len < s.length(); len ++){
            for(int start = 0; start + len < s.length(); start++){
                m[start][start + len] = (m[start + 1][start + len - 1] || len == 1)&& s.charAt(start) == s.charAt(start + len);
            }
        }
        return m;
    }
}