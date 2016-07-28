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
    public int rob(TreeNode root) {
        return helper(root, new HashMap());
    }
    private int helper(TreeNode node, HashMap<TreeNode, Integer> map){
        if(node == null){
            return 0;
        }
        if(map.containsKey(node)) return map.get(node);
        int val = 0;
        if(node.left != null){
            val += helper(node.left.left, map) + helper(node.left.right, map);
        }
        if(node.right != null){
            val += helper(node.right.left, map) + helper(node.right.right, map);
        }
        val = Math.max(val + node.val, helper(node.left, map) + helper(node.right, map));
        map.put(node, val);
        return val;
    }
}