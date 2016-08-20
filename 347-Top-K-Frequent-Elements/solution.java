public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }else{
                map.put(n, 1);
            }
        }
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((p1, p2) -> (p1.freq - p2.freq));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.offer(new Pair(entry.getKey(), entry.getValue()));
            if(queue.size() > k) queue.poll();
        }
        for(Pair p : queue){
            res.add(p.val);
        }
        return res;
    }
    class Pair{
        int val;
        int freq;
        Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }
}