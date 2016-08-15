1. if sum gas[i] - cost[i] < 0, then there is no solution.
2. if sum[i..k] >= 0 but sum[i .. k + 1] < 0 then i...k+1 can't be the start.

Approval:

 so there are two possibilities:
1. gas[i + 1] - cost[i + 1] > 0 (if sum < 0 then sum - positive integer is also < 0)
2. gas[i + 1] - cost[i + 1] < 0 (start with negative)
for the first one, if [i..k] >= 0 but [i .. k + 1] < 0, then for both cases, i+1 can't be the start. so far so on....


is sum = 0, should be fine