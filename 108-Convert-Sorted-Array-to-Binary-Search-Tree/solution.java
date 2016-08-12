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
        if(nums == null || nums.length == 0) return null; 
        return build(nums, 0, nums.length - 1);
    }
    private TreeNode build(int[] nums, int s, int e){
        if(s > e) return null;
        int mid = s - (s - e) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, s, mid - 1);
        root.right = build(nums, mid + 1, e);
        return root;
    }
}