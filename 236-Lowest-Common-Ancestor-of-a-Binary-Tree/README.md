divide the problem: find q or p in both left and right children.
conquer:  if left and right subtree both contain p and q accordingly, then root is the result. if q and p only locate in single branch : left/right subtree, then q or q is the result, otherwise return null.

               3
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4

if p = 5, q = 4, once we find 5, then return 5.