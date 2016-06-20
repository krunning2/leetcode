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
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Queue<Pair> q = new LinkedList<Pair>();
        Pair p = new Pair(0, root);
        q.offer(p);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair cur = q.poll();
                map.putIfAbsent(cur.col, new ArrayList<Integer>());
                map.get(cur.col).add(cur.node.val);
                if(cur.node.left != null){
                    Pair tmp = new Pair(cur.col - 1, cur.node.left);
                    q.offer(tmp);
                }
                if(cur.node.right != null){
                    Pair tmp = new Pair(cur.col + 1, cur.node.right);
                    q.offer(tmp);
                }
                max = Math.max(max, cur.col);
                min = Math.min(min, cur.col);
            }
        }
        for(int i = min; i<=max; i++){
            res.add(map.get(i));
        }
        return res;
    }
    class Pair{
        TreeNode node;
        int col;
        Pair(int c, TreeNode n){
            node = n;
            col = c;
        }
    }
}