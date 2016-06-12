public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int lives = getLives(board, i, j);
                if(lives == 3 && (board[i][j] == 0)){
                    board[i][j] = 2;
                }
                if((board[i][j] == 1) && (lives == 3 || lives == 2)){
                    board[i][j] = 3;
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] >>= 1;
            }
        }
    }
    
    private int getLives(int[][] board, int x, int y){
        int m = board.length - 1;
        int n = board[0].length - 1;
        int count = 0;
        for(int i = Math.max(0, x - 1); i <= Math.min(x + 1, m); i++){
            for(int j = Math.max(0, y - 1); j <= Math.min(y + 1, n); j++){
                count += board[i][j] & 1;
            }
        }
        if((board[x][y] & 1) == 1){
            count--;
        }
        return count;
    }
}