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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null) return res;
        DFS(root, res, new StringBuilder());
        return res;
    }
    
    private void DFS(TreeNode node, List<String> res, StringBuilder sb){
        String val = String.valueOf(node.val);
        sb.append(val).append("->");
        if(node.left == null && node.right == null){
            res.add(sb.toString().substring(0, sb.length() - 2));
            sb.delete(sb.length() - 2 - val.length(), sb.length());
            return;
        }
        
        if(node.left != null){
            DFS(node.left, res, sb);
        }
        if(node.right != null){
            DFS(node.right, res, sb);
        }
        sb.delete(sb.length() - 2 - val.length(), sb.length());
    }
}