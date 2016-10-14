public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int[] map = new int[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        Map<Integer, Integer> counter = new HashMap<Integer, Integer>();
        List<String> res = new ArrayList<String>();
        for(int i = 0; i <= s.length() - 10; i++){
            int key = 0;
            for(int j = i; j < 10 + i; j++){
                key |= map[s.charAt(j) - 'A'];
                key <<= 2;
            }
            if(counter.containsKey(key) && counter.get(key) == 1){
                res.add(s.substring(i, i + 10));
                counter.put(key, 2);
            }
            counter.putIfAbsent(key, 1);
        }
        return res;
    }
}