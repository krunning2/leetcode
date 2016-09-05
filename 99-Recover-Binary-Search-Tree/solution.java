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
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode p1 = null, p2 = null;
        TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
        boolean foundFirst = false;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(cur.val <= preNode.val){
                if(!foundFirst){
                    p1 = preNode;
                    // to avoid the root is the wrong node
                    p2 = cur;
                    foundFirst = true;
                }else{
                    p2 = cur;
                    break;
                }
            }
            preNode = cur;
            cur = cur.right;
        }
        int tmp = p1.val;
        p1.val = p2.val;
        p2.val = tmp;
    }
}