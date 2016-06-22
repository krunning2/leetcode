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
    private int find(TreeNode root, int pre, int length){
        if(root == null){
            return length;
        }
        length = pre + 1 == root.val ? length + 1 : 1;
        int lengthLeft = find(root.left, root.val, length);
        int lengthRight = find(root.right, root.val, length);
        return Math.max(lengthLeft, Math.max(length, lengthRight));
    }
}