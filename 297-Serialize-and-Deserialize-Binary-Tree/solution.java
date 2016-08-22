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
    private static String DELIMETER = ",";
    private static String NULL = "N";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(NULL).append(DELIMETER);
            return;
        }
        sb.append(root.val).append(DELIMETER);
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(DELIMETER);
        return deserializeHelper(new Pointer(0), parts);
    }
    private TreeNode deserializeHelper(Pointer p, String[] parts){
        if(p.cur >= parts.length) return null;
        String value = parts[p.cur ++];
        if(value.equals(NULL)){
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = deserializeHelper(p, parts);
        root.right = deserializeHelper(p, parts);
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