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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        DFS(res, new ArrayList<>(), sum, root);
        return res;
    }
    private void DFS(List<List<Integer>> res, List<Integer> list, int sum, TreeNode root){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList<>(list));
        }
        DFS(res, list, sum - root.val, root.left);
        DFS(res, list, sum - root.val, root.right);
        list.remove(list.size() - 1);
    }
}