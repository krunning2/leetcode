/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static String NULL = "#";
    private static String DELIMITER = ",";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(new StringBuilder(), root).toString();
    }
    private StringBuilder serializeHelper(StringBuilder sb, TreeNode root){
        if(root == null){
            sb.append(NULL).append(DELIMITER);
            return sb;
        }
        sb.append(root.val).append(DELIMITER);
        sb = serializeHelper(sb, root.left);
        sb = serializeHelper(sb, root.right);
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(DELIMITER);
        return deserializeHelper(nodes, new Pointer(0));
    }
    private TreeNode deserializeHelper(String[] nodes, Pointer p){
        if(p.cur >= nodes.length){
            return null;
        }
        String value = nodes[p.cur++];
        if(value.equals(NULL)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = deserializeHelper(nodes, p);
        root.right = deserializeHelper(nodes, p);
        return root;
    }
    private class Pointer{
        int cur;
        Pointer(int cur){
            this.cur = cur;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));