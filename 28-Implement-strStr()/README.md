KMP algorithm:

1. calculate the next array.
Define Next[j] = k as for T[0...k] are same as T[j - k...j - 1]; Also we can first calculate the longest common prefix and suffix for given j, then move them to right by one step.
next[0] = -1;
So if(T[j] == T[k]) then next[j + 1] = next[j] + 1 = k + 1; 
if(T[j] != T[k]) then recursively to find the shorter length by calling k = next[k];

2. Find the substring
A[i]
B[j]
Keep moving i, if A[i] == B[j] then move both pointers to next, else then don't move i but move j back by calling j = next[j]. (the call also means moving B array to the right by j - next[j] steps)

3. Optimization.

When creating the next array, we should check whether T[j+1] == T[k+1]. if yes, then next[j] = next[k]; else next[j] = k; To avoid abab = -1 0 0 1. abcabab. It should be -1 0 -1 1.

Ex.

ababcababa
ababa

 







http://blog.csdn.net/v_july_v/article/details/7041827