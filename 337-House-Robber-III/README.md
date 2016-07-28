for each tree root, there are two scenarios: it is robbed or is not
1. max = (cur.val + the value of subtree which exclude its children) or (the val of subtree which include its children but not the cur node) so do it recursively.

2. [ 0 ] means doesn't include the current node, [ 1 ] means include current node.



ref
https://discuss.leetcode.com/topic/39834/step-by-step-tackling-of-the-problem/2
http://www.cnblogs.com/grandyang/p/5275096.html