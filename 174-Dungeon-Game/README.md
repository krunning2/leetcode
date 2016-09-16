Initially, I thought we should from button right to up right and pick the min from right or down, but it is not going to work.


define dp[i][j] as the min HP we need to reach i, j
So we should keep a dp matrix or re-use the original one. 
dp[i][j] = Max(1, Min(dp[i + 1][ j ], dp[ i ][ j + 1]) - dungeon[ i ][ j ]);