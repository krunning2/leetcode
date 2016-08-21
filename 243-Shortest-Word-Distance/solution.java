public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        HashMap<String, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1) && map.containsKey(word2)){
                res = Math.min(res, i - map.get(word2));
            }else if(words[i].equals(word2) && map.containsKey(word1)){
                res = Math.min(res, i - map.get(word1)):
            }else{
                map.put(words[i], i);
            }
        }
        return res;
    }
}