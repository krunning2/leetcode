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
        List<Integer> res = new ArrayList<Integer> ();
        inorder(root, target, k, res);
        return res;
    }
    private void inorder(TreeNode root, double target, int k, List<Integer> res){
        if(root == null){
            return;
        }
        inorder(root.left, target, k, res);
        if(res.size() == k){
            if(Math.abs(root.val - target) < Math.abs(target - res.get(0))){
                res.remove();
            }else{
                return;
            }
        }
        res.add(root.val);
        inorder(root.right, target, k, res);
    }
}