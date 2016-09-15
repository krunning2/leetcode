public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        boolean[][] matrix = getMatrix(s);
        DFS(res, new ArrayList<>(), s, 0, matrix);
        return res;
    }
    private void DFS(List<List<String>> res, List<String> cur, String s, int pos, boolean[][] matrix){
        if(pos == s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = pos; i < s.length(); i++){
            if(matrix[pos][i]){
                cur.add(s.substring(pos, i + 1));
                DFS(res, cur, s, i + 1, matrix);
                cur.remove(cur.size() - 1);
            }
        }
    }
    private boolean[][] getMatrix(String s){
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        for(int len = 1; len < s.length(); len ++){
            for(int i = 0; i + len < s.length(); i++){
                if(s.charAt(i) == s.charAt(i + len) && (len == 1 || dp[i + 1][i + len - 1])){
                    dp[i][i + len] = true;
                }
            }
        }
        return dp;
    }
}