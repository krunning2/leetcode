public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>(primes.length, new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return n1.val - n2.val;
            }
        });
        int[] list = new int[n];
        list[0] = 1;
        for(int i = 0; i < primes.length; i++){
            queue.offer(new Node(primes[i], 0, primes[i]));
        }
        for(int i = 1; i < n; i++){
            Node cur = queue.peek();
            list[i] = cur.val;
            while(!queue.isEmpty() && cur.val == queue.peek().val){
                Node tmp = queue.poll();
                tmp.index ++;
                tmp.val = list[tmp.index] * tmp.prime;
                queue.offer(tmp);
            }
        }
        return list[n - 1];
    }
    
    class Node{
        int index;
        int prime;
        int val;
        Node(int val, int index, int prime){
            this.val = val;
            this.index = index;
            this.prime = prime;
        }
    }
}