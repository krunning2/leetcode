define
dp[i][j] as the minimum steps that change first i characters from A to first j characters from B.
dp[i][j] = dp[i - 1][j - 1] if A[i - 1] == B[j - 1]
           = Min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1