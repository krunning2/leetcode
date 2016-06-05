1. Write a function to get max subarray with length k
2. Enumerate all cases, 0...k 
2.1 So i starts with k - len2, which tells the minimum elements should be selected from nums1, ends with  i <= len1 && i <= k;
3. Merge two array into one, pay attention to the same digit case, like 04, 0 which should be 040 instead of 004

https://www.hrwhisper.me/leetcode-create-maximum-number/