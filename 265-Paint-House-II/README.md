dp[i][j]: the minimum cost for painting previous houses and paint ith hourse as j color.

dp[i][j] =  Min( dp[i - 1][k] ) + costs[i][j] where j != k

points: min1 min2 switch