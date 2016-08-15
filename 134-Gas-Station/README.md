1. if sum gas[i] - cost[i] < 0, then there is no solution.
2. if sum[i..k] >= 0 but sum[i .. k + 1] < 0 then i...k+1 can't be the start.