for(int i = 0; i < m; i++)
            for(int j = 0; j < nb; j++)
                for(int k = 0; k < n; k++)
                    res[i][j] += A[i][k] * B[k][j];

if it is not the sparse matrix.

But in the sparse matrix case, we can optimize by check A[i][k] == 0, which we don't have to check B[k][j] where k < n; 

in other words, if A[i][k] is zero, A[i][k] * B[k][j] is zero for whole column k. 

思路： 先来最基础的解法，然后把for loop 兑换， 会发现res[i][j] += A[i][k] * B[k][j]; A[i][k] 都不变，所以只要check A[i][k] != 0