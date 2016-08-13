Define dp[i] as min #changes required for i amount.
so dp[ i ] = Math.min( dp[ i ], dp[i - coins[ j ]] + 1); take or not take from the coins.
Also fill dp[0] as 0 and others as amount + 1.
At the end, check dp[amount] > amount ? if so, means there is no possible solution.