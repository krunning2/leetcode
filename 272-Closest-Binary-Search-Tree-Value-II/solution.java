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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(root, target, k, res);
        return res;
    }
    private void helper(TreeNode root, double target, int k, LinkedList<Integer> res){
        if(root == null) return;
        helper(root.left, target, k, res);
        if(res.size() == k){
            if(Math.abs(res.getFirst() - target) > Math.abs(root.val - target)){
                res.removeFirst();
            }else{
                return;
            }
        }
        res.add(root.val);
        helper(root.right, target, k, res);
    }
}