public class Solution {
    public void solveSudoku(char[][] board) {
        resolve(board);
    }
    private boolean resolve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        board[i][j] = c;
                        if(isSudoku(board) && resolve(board)){
                            return true;
                        }
                        board[i][j] = '.';
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
        for(int i = 0; i < 9; i = i + 3){
            for(int j = 0; j < 9; j = j + 3){
                Arrays.fill(visited, false);
                for(int k = 0; k < 9; k ++){
                    if(!isValid(board[i + k / 3][j + k % 3], visited)){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char c, boolean visited[]){
        if(c == '.') return true;
        if(c < '1' || c > '9' || visited[c - '1']) return false;
        visited[c - '1'] = true;
        return true;
    }
}