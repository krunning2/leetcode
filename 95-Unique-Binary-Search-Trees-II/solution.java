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
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0){
            return new ArrayList<TreeNode>();
        }
        return build(1, n);
    }
    private List<TreeNode> build(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode> ();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = build( start, i - 1);
            List<TreeNode> right = build(i + 1, end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}