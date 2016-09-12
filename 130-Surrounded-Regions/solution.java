public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        Queue<Point> queue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O'){
                queue.offer(new Point(i, 0));
                board[i][0] = 'P';
            }
            if(board[i][n - 1] == 'O'){
                queue.offer(new Point(i, n - 1));
                board[i][n - 1] = 'P';
            }
        }
        for(int i = 0; i < n; i++){
            if(board[0][i] == 'O'){
                queue.offer(new Point(0, i));
                board[0][i] = 'P';
            }
            if(board[m - 1][i] == 'O'){
                queue.offer(new Point(m - 1, i));
                board[m - 1][i] = 'P';
            }
        }
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        while(! queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Point p = queue.poll();
                for(int k = 0; k < 4; k++){
                    if(isValid(p.row + dx[k], p.col + dy[k], board)){
                        queue.offer(new Point(p.row + dx[k], p.col + dy[k]));
                        board[p.row + dx[k]][p.col + dy[k]] = 'P';
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != 'P'){
                    board[i][j] = 'X';
                }else{
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private boolean isValid(int row, int col, char[][] b){
        if(col < 0 || row < 0 || col >= b[0].length || row >= b.length || b[row][col] != 'O'){
            return false;
        }
        return true;
    }
    
    class Point{
        int row;
        int col;
        Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
}