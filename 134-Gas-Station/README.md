1. if sum gas[i] - cost[i] < 0, then there is no solution.
2. if sum[i..k] >= 0 but sum[i .. k + 1] < 0 then i...k+1 can't be the start.

Approval:

0,  1, 2, 3,  4,  5
1, -1, 3, 4, -8, 9
you stop by -8, because total = -1. so 0-4 can't be start. because total < 0, total subtract a positive number is also < 0. or total has to subtract a negative to become greater than 0, but it is impossible, since we can't start with a negative point.


 so there are two possibilities:
1. gas[i + 1] - cost[i + 1] > 0 (if sum < 0 then sum - positive integer is also < 0)
2. gas[i + 1] - cost[i + 1] < 0 (start with negative)
for the first one, if [i..k] >= 0 but [i .. k + 1] < 0, then for both cases, i+1 can't be the start. so far so on....


is sum = 0, should be fine