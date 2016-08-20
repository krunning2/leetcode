public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length];
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n) + 1);
            }else{
                map.put(n, 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(bucket[entry.getValue()] == null){
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(int n : bucket[i]){
                    res.add(n);
                }
            }
        }
        return res;
    }
}