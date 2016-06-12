DP 
Define dp[ i ] as the minimum number to sum up to i;
dp[ i + j * j ] = min (dp[ i + j * j ], dp[ i ] + 1), where i + j * j <= n; 