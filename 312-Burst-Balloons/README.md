dp[i][j] = max(dp[i][j], nums[i - 1] * nums[k] * nums[j + 1] + dp[i][k - 1] + dp[k + 1][j]) where i < k < j

Instead of thinking which one is the first balloon to burst, we are thinking who is the last one to burst, so it won't affect the adjacent 