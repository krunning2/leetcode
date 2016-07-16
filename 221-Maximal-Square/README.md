Define dp[i][j] as the length which ends on bottom right position that can form the largest square.

So dp[i][j] = m[i][j] == 0 ? 0 : Min(dp[ i ][j - 1], dp[i - 1][j - 1], dp[i - 1][ j ] )

Optimize the space complicity: 

dp[i % 2][ j ] = 