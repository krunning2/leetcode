public class WordDistance {
    Map<String, List<String>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<String>>();
        for(int i = 0; i < words.length; i++){
            String s = words[i];
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<String>());
            }
            map.get(s).add(i);
        }
        
    }

    public int shortest(String word1, String word2) {
        List<String> l1 = map.get(word1);
        List<String> l2 = map.get(word2);
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while(i < l1.size() && j < l2.size()){
            min = Math.min(min, Math.abs(l1.get(i) - l2.get(j)));
            if(l1.get(i) > l2.get(j)){
                j++;
            }else{
                i++;                
            }
        }
        return min;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");