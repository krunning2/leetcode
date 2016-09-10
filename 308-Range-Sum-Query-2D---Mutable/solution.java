public class NumMatrix {
    int[][] BIT2D;
    int[][] matrix;
    int m, n;
    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return;
        }
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        BIT2D = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j ++){
                updateBIT(i, j, matrix[i][j]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        updateBIT(row, col, diff);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) - getSum(row2, col1 - 1) - getSum(row1 - 1, col2) + getSum(row1 -1 , col1 - 1); 
    }
    
    private void updateBIT(int row, int col, int val){
        for(int i = row + 1; i <= m; i += i & -i){
            for(int j = col + 1; j <= n; j += j & -j){
                BIT2D[i][j] += val;
            }
        }
    }
    
    private int getSum(int row, int col){
        int sum = 0;
        for(int i = row + 1; i > 0; i -= i & -i){
            for(int j = col + 1; j > 0; j -= j & -j){
                sum += BIT2D[i][j];
            }
        }
        return sum;
    }
    
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);