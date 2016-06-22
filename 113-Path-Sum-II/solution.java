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
        List<List<Integer>>res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        helper(root, sum, res, new ArrayList<>());
        return res;
    }
    private void helper(TreeNode root, int sum, List<List<Integer>>res, List<Integer>list){
        if(root.left == null && root.right == null && root.val == sum){
            list.add(sum)
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        list.add(root.val);
        if(root.left != null){
            helper(root.left, sum - root.val, res, list);
        }
        if(root.right != null){
            helper(root.right, sum - root.val, res, list);
        }
        list.remove(list.size() - 1);
    }
}