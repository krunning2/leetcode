public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        Map<Integer, Integer> counter = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length() - 9; i++){
            int v = 0;
            for(int j = i; j < i + 10; j++){
                v = v << 2;
                v |= map[s.charAt(j) - 'A'];
            }
            if(counter.containsKey(v) && counter.get(v) == 1){
                counter.put(v, 2);
                res.add(s.substring(i, i + 10));
            }else if(!counter.containsKey(v)){
                counter.put(v, 1);
            }
        }
        return res;
    }
}