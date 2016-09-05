public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int total = 0;
        int len = Integer.MAX_VALUE;
        String res = "";
        for(char c : t.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c) + 1);
            }
            total++;
        }
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            while(total > 0 && j < s.length()){
                char cur = s.charAt(j);
                if(map.containsKey(cur)){
                    // only decrease the total counter when there is no redundent chars
                    if(map.get(cur) > 0){
                        total --;
                    }
                    map.put(cur, map.get(cur) - 1);
                }
                j++;
            }
            if(total == 0){
                if(j - i < len){
                    len = j - i;
                    res = s.substring(i, j);
                }
            }
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                // means no redundent chars in the window
                if(map.get(cur) >= 0){
                    total ++;
                }
                // remove one from the map
                map.put(cur, map.get(cur) + 1);
            }
        }
        return res;
    }
}