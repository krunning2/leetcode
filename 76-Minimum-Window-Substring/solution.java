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
        
        for(int i = 0; i < s.length(); i++){
            int j = 0;
            while(total > 0 && j < s.length()){
                char cur = s.charAt(j);
                if(map.containsKey(cur) && map.get(cur) > 0){
                    total --;
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
                total ++;
                map.put(cur, map.get(cur) + 1);
            }
        }
        return res;
    }
}