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
        for(int i = nums.length - 1; i >= 0; i++){
            modify(root, sum);
            sum -= nums[i];
            res += query(root, lower + sum, upper + sum);
        }
        return (int) res;
    }
    
    private Node build(int start, int end, long[] A){
        if(start > end){
            return null;
        }
        if(start == end){
            return new Node(A[start], A[end], 0L);
        }
        long mid = (start + end) >> 1;
        Node root = new Node(A[start], A[end], 0L);
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
    private void modify(Node root, long val){
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
        
        Node(int start, int end, long val){
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }
}