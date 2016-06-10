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
        Stack<TreeNode> predecessor = new Stack<TreeNode>();
        Stack<TreeNode> successor = new Stack<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        while(root != null){
            if(root.val <= target){
                predecessor.push(root);
                root = root.right;
            }else{
                successor.push(root);
                root = root.left;
            }
        }
        while(k > 0){
            if(!predecessor.isEmpty() && !successor.isEmpty()){
                break;
            }
            if(predecessor.isEmpty()){
                res.add(getSuccessor(successor));
            } else if(successor.isEmpty()){
                res.add(getPredecessor(predecessor));
            } else if(Math.abs(successor.peek() - target) < Math.abs(predecessor.peek() - target)){
                res.add(getSuccessor(successor));
            }else{
                res.add(getPredecessor(predecessor));
            }
            k--;
        }
        return res;
    }
    private int getPredecessor(Stack<TreeNode> predecessor){
        TreeNode top = predecessor.pop();
        TreeNode cur = top.left;
        while(cur != null){
            predecessor.push(cur);
            cur = cur.right;
        }
        return top.val;
    }
    
    private int getSuccessor(Stack<TreeNode> successor){
        TreeNode top = successor.pop();
        TreeNode cur = top.right;
        while(cur != null){
            successor.push(cur);
            cur = cur.left;
        }
        return top.val;
    }
}