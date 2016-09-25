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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        find(root, res);
        return res;
    }
    private int find(TreeNode root, List<List<Integer>> res){
        if(root == null){
            return -1;
        }
        int left = find(root.left, res);
        int right = find(root.right, res);
        int depth = Math.max(left, right) + 1;
        if(depth >= res.size()){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        return depth;
    }
}