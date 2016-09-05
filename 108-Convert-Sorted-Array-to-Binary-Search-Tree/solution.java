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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(0, nums.length - 1, nums);
    }
    private TreeNode helper(int start, int end, int[] nums){
        if(start > end) return null;
        int mid = start - (start - end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(start, mid - 1, nums);
        root.right = helper(mid + 1, end, nums);
        return root;
    }
}