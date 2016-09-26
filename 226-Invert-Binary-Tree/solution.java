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
    public TreeNode invertTree(TreeNode tn) {
        if(tn==null)
			return tn;
		TreeNode left= tn.left;
		TreeNode right = tn.right;
		tn.right=invertTree(left);
		tn.left=invertTree(right);
		return tn;
    }
}