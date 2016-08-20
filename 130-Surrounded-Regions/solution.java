public class Solution {
    private static final char GATE = 'O';
    private static final char PASS = 'P';
    private static final char WALL = 'X';
    public void solve(char[][] board) {
        if(board == null || board.length == 0) return;
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == GATE){
                    board[i][j] = PASS;
                    if(i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1){
                        queue.offer(new Point(i, j));
                        board[i][j] = GATE;
                    }
                }
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
                        board[p.row + dx[k]][p.col + dy[k]] = GATE;
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != GATE){
                    board[i][j] = WALL;
                }
            }
        }
    }
    
    private boolean isValid(int row, int col, char[][] b){
        if(col < 0 || row < 0 || col >= b[0].length || row >= b.length || b[row][col] != PASS){
            return false;
        }
        return true;
    }
    
    class Point{
        int row;
        int col;
        Point(int row, int col){
            this.row = row;
            this.col = co;
        }
    }
}