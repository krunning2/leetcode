public class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        int cow = 0;
        int bull = 0;
        for(char c : secret.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
        }
        for(int i = 0; i < guess.length(); i++){
            char g = guess.charAt(i);
            char s = secret.charAt(i);
            if(g == s){
                bull++;
                map.put(g, map.get(g) - 1);
            }
        }
        for(int i = 0; i < guess.length(); i++){
            char g = guess.charAt(i);
            char s = secret.charAt(i);
            if(g != s && map.containsKey(g) && map.get(g) > 0){
                cow++;
                map.put(g, map.get(g) - 1);
            }
        }
        return bull + "A" + cow + "B";
    }
}