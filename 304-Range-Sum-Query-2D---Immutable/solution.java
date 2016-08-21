public class NumMatrix {
    private int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].lenght; j++){
                if(i == 0 && j == 0) continue;
                if(i == 0){
                    matrix[i][j] += matrix[i][j-1];
                }else if(j == 0){
                    matrix[i][j] += matrix[i - 1][j];
                }else{
                    matrix[i][j] += matrix[i - 1][j] + matrix[i][j - 1] - matrix[i - 1][j - 1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrix[row2][col1] + matrix[row1][col2] - matrix[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);