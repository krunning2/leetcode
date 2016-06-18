# 323. Number of Connected Components in an Undirected Graph

[Original Page](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)

Given `n` nodes labeled from `0` to `n - 1` and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

**Example 1:**  

<pre>     0          3
     |          |
     1 --- 2    4
</pre>

Given `n = 5` and `edges = [[0, 1], [1, 2], [3, 4]]`, return `2`.

**Example 2:**  

<pre>     0           4
     |           |
     1 --- 2 --- 3
</pre>

Given `n = 5` and `edges = [[0, 1], [1, 2], [2, 3], [3, 4]]`, return `1`.

**Note:**  
You can assume that no duplicate edges will appear in `edges`. Since all edges are undirected, `[0, 1]` is the same as `[1, 0]` and thus will not appear together in `edges`.

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Hide Company Tags</div>

<span class="hidebutton" style="display: inline;">[Google](/company/google/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Hide Tags</div>

<span class="hidebutton" style="display: inline;">[Depth-first Search](/tag/depth-first-search/) [Breadth-first Search](/tag/breadth-first-search/) [Graph](/tag/graph/) [Union Find](/tag/union-find/)</span></div>

<div>

<div id="similar" class="btn btn-xs btn-warning">Hide Similar Problems</div>

<span class="hidebutton" style="display: inline;">[(M) Number of Islands](/problems/number-of-islands/) [(M) Graph Valid Tree](/problems/graph-valid-tree/)</span></div>