博弈类问题：
这里假设就只能拿1个或两个硬币
Consider A and B players, A will take first place then B.
so define dp[x] as A first takes coins from the remaining x coins whether A can win.
so dp[x] = dp[x - 2] && dp[x - 3] || dp[x - 3] && dp[x - 4] 
dp[x - 2] && dp[x - 3] means B takes 1 coin, the state of A.
dp[x - 3] && dp[x - 4]  means B takes 2 coins, the state of A.