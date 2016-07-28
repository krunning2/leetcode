for each tree root, there are two scenarios: it is robbed or is not
1. max = (cur.val + the value of subtree which exclude its children) or (the val of subtree which include its children but not the cur node) so do it recursively.
