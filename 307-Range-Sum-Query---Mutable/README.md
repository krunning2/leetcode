我们定义：C[i] = A[i - 2^k + 1] + ..... + A[i]  其中k为i用二进制表示时的末尾0的个数。例如：i= 10100,则k = 2，i = 11000，则k = 3；

求sum(0..11000) 
11000 = 2^3 + 2^4 = C[2^3] + C[2^4], 
11000 - 2^k(k = lowBit(11000)) = 10000(2 ^ k, k = lowBit(10000)) 

http://blog.csdn.net/ljd4305/article/details/10101535
http://blog.csdn.net/int64ago/article/details/7429868