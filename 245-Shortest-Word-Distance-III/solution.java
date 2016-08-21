public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(word1.equals(word2) && words[i].equals(word1)){
                if(p1 == -1 || p2 > p1){
                    p1 = i;
                }else {
                    p2 = i;
                }
            } else {
               if(words[i].equals(word1)){
                    p1 = i;
                }
                if(words[i].equals(word2)){
                    p2 = i;
                }
            }
            if(p1 != -1 && p2 != -1){
                res = Math.min(Math.abs(p1 - p2), res);
            } 
        }
        return res;
    }
}