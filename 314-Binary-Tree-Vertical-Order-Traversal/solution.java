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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        int max = 0, min = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<NodeWrapper> queue = new LinkedList<>();
        queue.offer(new NodeWrapper(root, 0));
        while(! queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                NodeWrapper cur = queue.poll();
                max = Math.max(max, cur.v);
                min = Math.min(min, cur.v);
                if(!map.containsKey(cur.v)){
                    map.put(cur.v, new ArrayList<>());
                }
                map.get(cur.v).add(cur.node.val);
                if(cur.node.left != null){
                    queue.offer(new NodeWrapper(cur.node.left, cur.v - 1));
                }
                if(cur.node.right != null){
                    queue.offer(new NodeWrapper(cur.node.right, cur.v + 1));
                }
            }
        }
        for(int i = min; i <= max; i++){
            res.add(map.get(i));
        }
        return res;
    }
    class NodeWrapper{
        TreeNode node;
        int v;
        NodeWrapper(TreeNode node, int v){
            this.v = v;
            this.node = node;
        }
    }
}