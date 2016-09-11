1. xor all elements get x1 XOR x2 => diff
2. get the lowbit, because x1 and x2 is distinct, so after xor, it must has at least one bit is 1.
3. divide x1, x2 into two groups by (x1 & lowbit) == 0, only one of them will be 0 after  (x1 & lowbit)

