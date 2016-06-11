1.define dp[i] as from 0 to i, max number of increasing subsequence. (must include i)
2. need to keep a global max, because dp[i] must include i, the max one could be in anywhere of subsequence. 

e.g. 100 110 120 90 95 