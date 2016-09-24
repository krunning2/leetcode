public class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> pos1 = map.get(word1);
        List<Integer> pos2 = map.get(word2);
        int p1 = 0, p2 = 0, res = Integer.MAX_VALUE;
        while(p1 < pos1.size() && p2 < pos2.size()){
            if(pos1.get(p1) == pos2.get(p2)){
                return 0;
            }else if(pos1.get(p1) > pos2.get(p2)){
                res = Math.min(res, pos1.get(p1) - pos2.get(p2));
                p2++;
            }else{
                res = Math.min(res, pos2.get(p2) - pos1.get(p1));
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