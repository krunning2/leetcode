The first solution is to find the first element which is greater/equal the target in the sorted array.

if(list.get(end) < target) return end + 1;

This is because the list may not have enough element to compare. like 1, when insert 3. Otherwise it will replace 1.

https://leetcode.com/discuss/73280/my-simple-ac-java-binary-search-code

Second solution
BST

Build a tree Node 
{
Node left, right;
int val;
int count; // count the #elements which are smaller/equal than itself. 
}

Traverse the array reversely, if val greater than current node and add current node count to total count, go right, else go left and increase the current node count;

https://leetcode.com/discuss/73280/my-simple-ac-java-binary-search-code