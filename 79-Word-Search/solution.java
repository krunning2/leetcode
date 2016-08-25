public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return false;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0) && DFS(board, word, new boolean[m][n], i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean DFS(char[][] board, String word, boolean[][] visited, int x, int y, int p){
        if(p == word.length()) return true;
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] || word.charAt(p) != board[x][y]){
            return false;
        }
        visited[x][y] = true;
        boolean res = 
           DFS(board, word, visited, x + 1, y, p + 1)
        || DFS(board, word, visited, x - 1, y, p + 1)
        || DFS(board, word, visited, x, y + 1, p + 1)
        || DFS(board, word, visited, x, y - 1, p + 1);
        visited[x][y] = false;
        return res;
    }
}