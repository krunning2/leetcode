public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return res;
        }
        res.add(0);
        if(nums.length == 1) return res;
        Node root = new Node(nums[nums.length - 1]);
        for(int i = nums.length - 2; i >= 0; i--){
            int count = insert(root, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }
    private int insert(Node root, int val){
        int cur = 0;
        while(true){
            if(val <= root.val){
                root.count ++;
                if(root.left == null){
                    root.left = new Node(val);
                    break;
                }else{
                    root = root.left;
                }
            }else{
                cur += root.count;
                if(root.right == null){
                    root.right = new Node(val);
                    break;
                }else{
                    root = root.right;
                }
            }
        }
        return cur;
    }
}
class Node{
    Node left;
    Node right;
    int val;
    int count;
    Node(int val){
        left = null;
        right = null;
        this.val = val;
        count = 1;
    }
}