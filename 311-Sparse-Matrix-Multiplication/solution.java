public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int nb = B[0].length;
        int[][] res = new int[A.length][nb];
        for(int i = 0; i < m; i++){
            for(int k = 0; k < n; k++)
                if(A[i][k] != 0)
                    for(int j = 0; j < nb; j++)
                        res[i][j] += A[i][k] * B[k][j];
        }
        return res;
    }
}