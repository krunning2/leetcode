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
        serializeHelper(root.left, sb);
        sb.append(root.val).append(NULL);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(DELIMETER);
        return deserializeHelper(0, parts.length - 1, parts);
    }
    private TreeNode deserializeHelper(int start, int end, String[] parts){
        if(start > end) return null;
        int mid = start - (start - end) / 2;
        if(parts[mid].equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(parts[mid]));
        root.left = deserializeHelper(start, mid - 1, parts);
        root.right = deserializeHelper(mid + 1, end, parts);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));