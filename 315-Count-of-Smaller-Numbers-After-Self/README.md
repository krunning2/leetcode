The first solution is to find the first element which is greater/equal the target in the sorted array.

if(list.get(end) < target) return end + 1;

This is because the list may not have enough element to compare. like 1, when insert 3. Otherwise it will replace 1.

https://leetcode.com/discuss/73280/my-simple-ac-java-binary-search-code