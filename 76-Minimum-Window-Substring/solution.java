public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        int count = 0;
        for(int i = 0; i < t.length(); i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            }else{
                map.put(t.charAt(i), 1);
            }
            count ++;
        }
        String result = "";
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            while(j < s.length() && count > 0){
                char tmp = s.charAt(j);
                if(map.containsKey(tmp)){
                    if(map.get(tmp) > 0){
                        count --;
                    }
                    map.put(tmp, map.get(tmp) - 1);
                }
                j++;
            }
            if(count == 0 && len > j - i){
                len = j - i;
                result = s.substring(i, j);
            }
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                if(map.get(cur) >= 0){
                    count++;
                }
                map.put(cur ,map.get(cur) + 1);
            }
        }
        return result;
    }
}