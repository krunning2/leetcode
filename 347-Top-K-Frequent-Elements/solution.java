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
        Pair[] pairs = new Pair[map.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pairs[i++] = new Pair(entry.getKey(), entry.getValue());
        }
        quickSelect(0, pairs.length - 1, pairs, k);
        for(int i = 0; i < k; i++){
            res.add(pairs[i].val);
        }
        return res;
    }
    
    private void quickSelect(int start, int end, Pair[] pairs, int k){
        if(start > end){
            return;
        }
        int index = partition(pairs, start, end, k);
        if(index == k - 1){
            return;
        } else if(index > k - 1){
            quickSelect(start, index - 1, pairs, k);
        } else {
            quickSelect(index + 1, end, pairs, k - index - 1);
        }
    }
    
    private int partition(Pair[] pairs, int start, int end){
        int index = start;
        Pair pivot = pairs[end];
        for(int i = start; i < end; i++){
            if(pairs[i] >= pivot.freq){
                Pair tmp = pairs[i];
                pairs[i] = pairs[index];
                pairs[index] = tmp;
                index++;
            }
        }
        Pair tmp = pairs[end];
        pairs[end] = pairs[index];
        pairs[index] = tmp;
        return index;
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