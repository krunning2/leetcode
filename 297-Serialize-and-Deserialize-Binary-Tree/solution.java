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
    public static final String DELIMETER = ",";
    public static final String NULL = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.substring(0, sb.length() - 1).toString();
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
        return deserializeHelper(data.split(DELIMETER), new Pointer());
    }
    
    private TreeNode deserializeHelper(String[] data, Pointer p){
        if(p.cur >= data.length) return null;
        String val = data[p.cur++];
        if(val.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserializeHelper(data, p);
        root.right = deserializeHelper(data, p);
        return root;
    }
    
    class Pointer{
        int cur = 0;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));