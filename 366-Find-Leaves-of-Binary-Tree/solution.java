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
        List<List<Integer>> res = new ArrayList();
        getDepth(root, res);
        return res;
    }
    private int getDepth(TreeNode root, List<List<Integer>> res){
        if(root == null) return -1;
        int level = 1 + Math.max(getDepth(root.left), getDepth(root.right));
        if(res.size() <= level){
            res.add(new ArrayList());
        }
        res.get(level).add(root.val);
        return level;
    }
}