for each tree root, there are two scenarios: it is robbed or is not
1. max = (cur.val + the value of subtree which exclude its children) or (the val of subtree which include its children but not the cur node) so do it recursively.


ref
https://discuss.leetcode.com/topic/39834/step-by-step-tackling-of-the-problem/2
http://www.cnblogs.com/grandyang/p/5275096.html