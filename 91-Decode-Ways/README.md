dp[ i ] = dp[i - 1] + dp[i - 2] if(second >= 10 && second <= 26) and first >= 1 and first <= 9
when using mod, should remember reset dp[i % 3] = 0;