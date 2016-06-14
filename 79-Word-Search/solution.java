public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.length() == 0){
            return false;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(DFS(board, word, i, j, new boolean[board.length][board[0].length], 0)) return true;
            }
        }
        return false;
    }
    private boolean DFS(char[][] board, String word, int x, int y, boolean[][] visited, int cur){
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited[x][y] || cur >= word.length()){
            return false;
        }
        if(board[x][y] != word.charAt(cur)){
            return false;
        }
        if(cur + 1 == word.length()) return true;
        visited[x][y] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        boolean flag = false;
        for(int i = 0; i < 4; i++){
            flag |= DFS(board, word, x + dx[i], y + dy[i], visited, cur + 1);
        }
        visited[x][y] = false;
        return flag;
    }
}