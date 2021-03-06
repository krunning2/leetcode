# 71. Simplify Path

[Original Page](https://leetcode.com/problems/simplify-path/)

Given an absolute path for a file (Unix-style), simplify it.

For example,  
**path** = `"/home/"`, => `"/home"`  
**path** = `"/a/./b/../../c/"`, => `"/c"`  

[click to show corner cases.](#)

<div class="spoilers" style="display: block;">**Corner Cases:**

*   Did you consider the case where **path** = `"/../"`?  
    In this case, you should return `"/"`.
*   Another corner case is the path might contain multiple slashes `'/'` together, such as `"/home//foo/"`.  
    In this case, you should ignore redundant slashes and return `"/home/foo"`.

</div>

<div>

<div id="company_tags" class="btn btn-xs btn-warning">Hide Company Tags</div>

<span class="hidebutton" style="display: inline;">[Microsoft](/company/microsoft/) [Facebook](/company/facebook/)</span></div>

<div>

<div id="tags" class="btn btn-xs btn-warning">Show Tags</div>

<span class="hidebutton">[Stack](/tag/stack/) [String](/tag/string/)</span></div>