public class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : secret.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
        }
        int bull = 0, cow = 0;
        for(int i = 0; i < guess.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bull ++;
                map.put(secret.charAt(i), map.get(secret.charAt(i)) - 1);
            }
        }
        for(int i = 0; i < guess.length(); i++){
            char g = guess.charAt(i);
            char s = secret.charAt(i);
            if(g != s && map.containsKey(g) && map.get(g) > 0){
                cow ++;
                map.put(g, map.get(g) - 1);
            }
        }
        return bull + "A" + cow + "B";
    }
}