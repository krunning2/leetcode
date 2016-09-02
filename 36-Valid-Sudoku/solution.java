public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        for(int i = 0; i < board.length; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j < board[0].length; j++){
                if(!validate(visited, board[i][j])) return false;
            }
        }
        for(int i = 0; i < board.length; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j < board[0].length; j++){
                if(!validate(visited, board[j][i])) return false;
            }
        }
        for(int i = 0; i < board.length; i += 3){
            for(int j = 0; j < board[0].length; j += 3){
                Arrays.fill(visited, false);
                for(int k = 0; k < 9; k++){
                    if(!validate(visited, board[i + k / 3][j + k % 3])){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean validate(boolean[] visited, char c){
        if(c == '.'){
            return true;
        }
        if(c < '1' || c > '9' || visited[c - '1']){
            return false;
        }
        visited[c - '1'] = true;
        return true;
    }
}