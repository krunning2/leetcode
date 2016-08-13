define f[i] is the min cut for [0...i)
f[i] = min(f[j]) + 1 given j from 0...i-1 such that A[0...i-1] is palindrome