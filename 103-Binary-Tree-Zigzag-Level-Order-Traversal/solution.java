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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root == null) return res;
        queue.offer(root);
        boolean flag = false;
        while(! queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            if(flag){
                Collections.reverse(tmp);
            }
            flag = !flag;
            res.add(tmp);
        }
        return res;
    }
}