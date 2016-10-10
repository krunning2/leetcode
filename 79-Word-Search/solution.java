public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null || word.length() == 0) return true;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(DFS(board, word, new boolean[board.length][board[0].length], 0, i, j)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean DFS(char[][] board, String word, boolean[][] visited, int pos, int x, int y){
        if(pos == word.length()) return true;
        if(x < 0 ||  y < 0 || x >= board.length || y >= board[0].length || visited[x][y] ||board[x][y] != word.charAt(pos)){
            return false;
        }
        visited[x][y] = true;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for(int i = 0; i < 4; i++){
            if(DFS(board, word, visited, pos + 1, x + dx[i], y + dy[i])){
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}