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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        int[] dp = new int[3];
        dp[0] = root.val;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int level = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            if(level == 0){
                dp[0] = sum;
            }else if(level == 1){
                dp[1] = Math.max(dp[0], sum);
            }else{
                dp[level % 3] = Math.max(dp[(level - 1) % 3], dp[(level - 2) % 3] + sum);
            }
            level++;
        }
        return dp[(level - 1) % 3]
    }
}