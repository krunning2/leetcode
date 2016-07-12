divide the number into four cases
[0], [1, 20), [20, 100), [100, 1000) [1000, )

every time, we just handle three digits with recursion. and divide by 1000 than append THOUSANDS.

Corner case: 0, hundreds, thousands