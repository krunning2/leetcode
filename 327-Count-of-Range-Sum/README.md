// count of range sum, segment tree solution
// based on this equation:
// low <= sum[i] - sum[j] <= high, i > j, which could be changed into:
// low + sum[j] <= sum[i] <= high + sum[j], i > j
// i ranges from 0 to n-1, j ranges from -1 to n-2
// sum[k] = sum of {num[0.....k]}, k ranges from 0 to n-1
// in order to control i > j during each segment tree query, add sum[i] one by one into the segment tree, from i = n-1 to 0
