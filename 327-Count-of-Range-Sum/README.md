// count of range sum, segment tree solution
// based on this equation:
// low <= sum[i] - sum[j] <= high, i > j, which could be changed into:
// low + sum[j] <= sum[i] <= high + sum[j], i > j
// i ranges from 0 to n-1, j ranges from -1 to n-2
// sum[k] = sum of {num[0.....k]}, k ranges from 0 to n-1
// in order to control i > j during each segment tree query, add sum[i] one by one into the segment tree, from i = n-1 to 0

     num = {1, 2, 3, 4, 5}
e.g sum ={1, 3, 6, 10, 15} 
we start from the end push 15 (1..5) into the tree, then find the [10 + lower, 10 + upper] in the tree(1..4) which means sum[1..5] - sum[1..4]. so keep moving left,   
