# 298. Binary Tree Longest Consecutive Sequence

[Original Page](https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/)

Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

For example,  

<pre>   1
    \
     3
    / \
   2   4
        \
         5
</pre>

Longest consecutive sequence path is `3-4-5`, so return `3`.

<pre>   2
    \
     3
    / 
   2    
  / 
 1
</pre>

Longest consecutive sequence path is `2-3`,not`3-2-1`, so return `2`.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Hide Company Tags</div>

<span class="hidebutton" style="display: inline;">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Hide Tags</div>

<span class="hidebutton" style="display: inline;">[Tree](/tag/tree/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Hide Similar Problems</div>

<span class="hidebutton" style="display: inline;">[(H) Longest Consecutive Sequence](/problems/longest-consecutive-sequence/)</span></div>