public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        res.add(0);
        int end = nums.length - 1;
        Node root = new Node(nums[end]);
        for(int i = end - 1; i >= 0; i--){
            res.add(insert(root, nums[i]));
        }
        Collections.reverse(res);
        return res;
    }
    
    private int insert(Node root, int val){
        int count = 0;
        while(true){
            // put same val into the left child, because we only count the smaller number not inclusive.
            if(val <= root.val){
                // increase the count 
                root.count++;
                if(root.left == null){
                    root.left = new Node(val);
                    break;
                }else{
                    root = root.left;
                }
            }else{
                // count the numbers who are greater than current number
                count += root.count;
                if(root.right == null){
                    root.right = new Node(val);
                    break;
                }else{
                    root = root.right;
                }
            }
        }
        return count;
    }
    
    
    class Node{
        Node left, right;
        int count;
        int val;
        Node(int val){
            left = null;
            right = null;
            count = 1;
            this.val = val;
        }
    }
}