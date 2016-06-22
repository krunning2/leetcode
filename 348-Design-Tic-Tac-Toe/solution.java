public class TicTacToe {
    int[] cols;
    int[] rows;
    int diagnoal;
    int anti_diagnoal;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        cols = new int[n];
        rows = new int[n];
        diagnoal = 0;
        anti_diagnoal = 0;
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int add = player == 1 ? 1 : -1;
        cols[col] += add;
        rows[row] += add;
        diagnoal += col == row ? add : 0;
        anti_diagnoal += row == n - col - 1 ? add : 0;
        if( cols[col] == n || rows[row] == n || diagnoal == n || anti_diagnoal == n) return 1;
        if(cols[col] == -n || rows[row] == -n || diagnoal == -n || anti_diagnoal == -n) return 2;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */