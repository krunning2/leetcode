博弈类问题：
这里假设就只能拿1个或两个硬币
Consider A and B players, A will take first place then B.
// A first take place, A can win only when B left 1 or 2 stones.
        //so dp[i] = !dp[i - 1] || !dp[i - 2] 