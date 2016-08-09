public class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    
    private boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char c = '0'; c <= '9'; c++){
                        board[i][j] = c;
                        if(isSudoku(board) && solve(board)) return true;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isSudoku(char[][] board){
        boolean[] visited = new boolean[9];
        for(int i = 0; i < 9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j < 9; j++){
                if(visited[board[i][j] - '1'] || !isValid(board[i][j])){
                    return false;
                }
                visited[board[i][j] - '1'] = true;
            }
        }
        
        for(int i = 0; i < 9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j < 9; j++){
                if(visited[board[i][j] - '1'] || !isValid(board[j][i])){
                    return false;
                }
                visited[board[i][j] - '1'] = true;
            }
        }
        
        for(int i = 0; i < 0; i = i + 3){
            for(int j = 0; j < 0; j = j + 3){
                Arrays.fill(visited, false);
                for(int k = 0; k < 9; k ++){
                    if(visited[board[i / 3 + k][j / 3 + k] - '1'] || !isValid(board[i / 3 + k][j / 3 + k])){
                        return false;
                    }
                    visited[board[i / 3 + k][j / 3 + k] - '1'] = true;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char c){
        return c < '9' && c > '0' || c == '.';
    }
}