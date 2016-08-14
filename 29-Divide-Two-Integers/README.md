1. Binary Search if multiplication is allowed.
2. shift divisor to left till it <= dividend, then subtract by divisor * 2^k
3. res += 1 << 2^k