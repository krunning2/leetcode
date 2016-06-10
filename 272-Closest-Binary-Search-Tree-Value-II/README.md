1. inorder traversal.
2. keep a window of size k
3. when reaching the size of k, compare the abs of first element and the current element

O(n)


Solution.2
1. initialize the two stacks, smaller element go to predecessor stack, larger one goes to successor stack and also push all visited nodes into stack for back tracking. 
2. to find a predecessor, go left child and then go rightmost.
3. to find a successor, go right child and then go leftmost.
4. while finding the predecessor/successor, we should keep push the visited nodes, then we can track the all the nodes.

k*log(n)

https://leetcode.com/discuss/71820/java-5ms-iterative-following-hint-o-klogn-time-and-space