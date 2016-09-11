public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        Set<Long> set = new HashSet<Long>();
        for(int x : nums){
            sum += x;
            set.add(sum);
        }
        long[] B = new long[set.size()];
        int j = 0;
        for(long x : set){
            B[j++] = x; 
        }
        Arrays.sort(B);
        long res = 0;
        Node root = build(0, B.length - 1, B);
        for(int i = nums.length - 1; i >= 0; i--){
            update(root, sum);
            sum -= nums[i];
            res += query(root, lower + sum, upper + sum);
        }
        return (int) res;
    }
    
    private Node build(int start, int end, long[] nums){
        if(start > end) return null;
        if(start == end) return new Node(nums[start], nums[end], 0L);
        int mid = (start + end) / 2;
        Node root = new Node(nums[start], nums[end], 0L);
        root.left = build(start, mid, nums);
        root.right = build(mid + 1, end, nums);
        return root;
    }
    
    private void update(Node root, long val){
        if(root == null){
            return;
        }
        if(val >= root.start && val <= root.end){
            root.val++;
            update(root.left, val);
            update(root.right, val);
        }
    }
    
    private long query(Node root, long start, long end){
        if(start > end || root == null || root.end < start || root.start > end){
            return 0;
        }
        if(start <= root.start && end >= root.end) return root.val;
        return query(root.left, start, end) + query(root.right, start, end);
    }
    
    
    class Node {
        Node left, right;
        long start, end;
        long val;
        Node(long start, long end, long val){
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
}