public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        Set<Long> set = new HashSet<Long>();
        for(int x : nums){
            sum += x;
            set.add(sum);
        }
        long[] B = new long[set.size()];
        int i = 0;
        for(int x : set){
            B[i++] = x; 
        }
        Arrays.sort(B);
        long res = 0;
        Node root = build(0, B.length - 1, B);
        for(int i = nums.length - 1; i >= 0; i++){
            modify(root, sum);
            sum -= nums[i];
            res += query(root, lower + sum, upper + sum);
        }
        return (int) res;
    }
    
    private Node build(long start, long end, long[] A){
        if(start > end){
            return null;
        }
        if(start == end){
            return new Node(A[start], A[end], 0);
        }
        long mid = (start + end) >> 1;
        Node root = new Node(A[start], A[end], 0);
        root.left = build(A[start], A[mid], A);
        root.left = build(A[mid + 1], A[end], A);
        return root;
    }
    private long query(Node root, long start, long end){
        if(root == null || root.end < start || root.start > end){
            return 0;
        }
        if(start <= root.start && end >= root.end){
            return root.val;
        }
        return query(root.left, start, end) + query(root.right, start, end);
    }
    private void modify(Node, root, long val){
        if(root == null){
            return;
        }
        if(root.start <= val && root.end >= val){
            root.val ++;
            modify(root.left, val);
            modify(root.right, val);
        }
    }
    class Node {
        Node left;
        Node right;
        int start;
        int end;
        long val;
        
        Node(int start, int end, int val){
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
}