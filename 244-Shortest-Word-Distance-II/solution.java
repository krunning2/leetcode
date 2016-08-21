public class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i])){
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<String> l1 = map.get(word1);
        List<String> l2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;
        while(p1 < l1.size() && p2 < l2.size()){
            if(l1.get(p1) == l2.get(p2)){
                return 0;
            }else if(l1.get(p1) > l2.get(p2)){
                res = Math.min(l1.get(p1) - l2.get(p2));
                p2++;
            }else{
                res = Math.min(l2.get(p2) - l1.get(p1));
                p1++;
            }
        }
        return res;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");