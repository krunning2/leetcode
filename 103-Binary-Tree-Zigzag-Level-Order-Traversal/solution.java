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
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while(! queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<Integer>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
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