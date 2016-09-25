public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null) return res;
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        Map<Integer, Integer> counter = new HashMap<>();
        for(int i = 0; i < s.length() - 9; i++){
            int v = 0;
            for(int j = i; j < 10 + i; j++){
                v |= map.get(s.charAt(j));
                v = v << 2;
            }
            if(counter.containsKey(v) && counter.get(v) == 1){
                res.add(s.substring(i, i + 10));
                counter.put(v, 2);
            }else if(!counter.containsKey(v)){
                counter.put(v, 1);
            }
        }
        return res;
    }
    
}