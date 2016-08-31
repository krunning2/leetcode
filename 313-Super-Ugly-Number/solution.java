public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(primes == null || primes.length == 0){
            return 1;
        }
        PriorityQueue<Node> queue = new PriorityQueue<Node>((a,b) -> (a.val - b.val));
        int[] num = new int[n];
        num[0] = 1;
        for(int prime : primes){
            queue.offer(new Node(0, prime, prime));
        }
        for(int i = 1; i < n; i++){
            Node cur = queue.peek();
            num[i] = cur.val;
            int min = cur.val;
            while(!queue.isEmpty() && queue.peek().val == min){
                Node minNode = queue.poll();
                minNode.index++;
                minNode.val = num[minNode.index] * minNode.prime;
                queue.offer(minNode);
            }
        }
        return num[n - 1];
    }
    class Node{
        int index;
        int val;
        int prime;
        Node(int index, int val, int prime){
            this.val = val;
            this.index = index;
            this.prime = prime;
        }
    }
}