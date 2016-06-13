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
        DFS(node, res, new StringBuilder());
        return res;
    }
    
    private void DFS(TreeNode node, List<String> res, StringBuilder sb){
        if(node == null){
            res.add(sb.toString().substring(0, sb.length() - 2));
            return;
        }
        String val = new String.valueOf(node.val);
        sb.append(val).append("->");
        DFS(node.left, res, sb);
        DFS(node.right, res, sb);
        sb.remove(sb.length() - 2 - val.length(), sb.length());
    }
}