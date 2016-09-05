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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(res, 0, root);
        Collections.reverse(res);
        return res;
    }
    private void DFS(List<List<Integer>> res, int level, TreeNode root){
        if(root == null) return;
        if(res.size() <= level){
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        DFS(res, level + 1, root.left);
        DFS(res, level + 1, root.right);
    }
}