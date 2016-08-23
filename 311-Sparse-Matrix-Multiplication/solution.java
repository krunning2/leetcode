public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = B[0].length;
        int[][] res = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; i++){
                for(int k = 0; i < m; k++){
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }
}