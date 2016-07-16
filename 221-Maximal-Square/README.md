Define dp[i][j] as the length which ends on bottom right position that can form the largest square.

So dp[i][j] = m[i][j] == 0 ? 0 : Min(dp[ i ][j - 1], dp[i - 1][j - 1], dp[i - 1][ j ] )

Optimize the space complicity: 

dp[i % 2][j] = matrix[i][j] == '1' ? Math.min(dp[(i-1) % 2][j-1], Math.min(dp[(i-1) % 2][j], dp[i % 2][j-1])) + 1 : 0;

Be careful, we when initialize the dp for the first column, we should calculate each time we go through each row.