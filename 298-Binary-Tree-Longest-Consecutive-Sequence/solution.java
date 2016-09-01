/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        return find(root, root.val - 1, 0);
    }
    private int find(TreeNode root, int pre, int len){
        if(root == null) return len;
        len = pre + 1 == root.val ? len + 1 : 1;
        int left = find(root.left, root.val, len);
        int right = find(root.right, root.val, len);
        return Math.max(len, Math.max(right, left));
    }
}