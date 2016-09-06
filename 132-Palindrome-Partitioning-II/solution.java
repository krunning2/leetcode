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
        int l = s.length();
        boolean[][] matrix = new boolean[l][l];
        for(int i = 0; i < l; i++){
            matrix[i][i] = true;
        }
        for(int len = 1; len < l; len++){
            for(int i = 0; i + len < l; i++){
                if(s.charAt(i) == s.charAt(i + len) && (len == 1 || matrix[i + 1][i + len - 1])){
                    matrix[i][i + len] = true;
                }
            }
        }
        return matrix;
    }
}