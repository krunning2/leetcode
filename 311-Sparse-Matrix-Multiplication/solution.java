public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length;
        int l = B[0].length;
        int[][] result = new int[m][l];
        for(int i = 0; i < m; i++){
            for(int k = 0; k < n; k++){
                if(A[i][k] != 0)
                    for(int j = 0; j < l; j++){
                        result[i][j] += A[i][k] * B [k][j];
                    }
            }
        }
        return result;
    }
}