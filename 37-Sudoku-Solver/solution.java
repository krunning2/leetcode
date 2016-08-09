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
                if(!isValid(board[i][j], visited)){
                    return false;
                }
            }
        }
        
        for(int i = 0; i < 9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j < 9; j++){
                if(!isValid(board[j][i], visited)){
                    return false;
                }
            }
        }
        
        for(int i = 0; i < 0; i = i + 3){
            for(int j = 0; j < 0; j = j + 3){
                Arrays.fill(visited, false);
                for(int k = 0; k < 9; k ++){
                    if(!isValid(board[i / 3 + k][j / 3 + k], visited)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char c, boolean visited[]){
        if(c == '.') return true;
        if(c < '0' || c > '9' || visited[c - '1']) return false;
        visited[c - '1'] = true;
        return true;
    }
}