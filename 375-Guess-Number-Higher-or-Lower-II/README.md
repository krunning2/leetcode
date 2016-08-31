define dp[i][j] as the from i to j minimum cost
we need to find minimum Math.max(dp[i][k - 1], dp[k + 1][j]) + k) (worse case) 