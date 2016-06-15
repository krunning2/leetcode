public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int res = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            while(j < s.length()){
                char cur = s.charAt(j);
                if(map.size() < k || map.containsKey(cur)){
                    if(map.containsKey(cur)){
                        map.put(cur, map.get(cur) + 1);
                    }else{
                        map.put(cur, 1);
                    }
                    j++;
                }else{
                    break;
                }
            }
            res = Math.max(res, j - i);
            char tmp = s.charAt(i);
            if(map.containsKey(tmp) && map.get(tmp) > 1){
                map.put(tmp, map.get(tmp) - 1);
            }else if(map.containsKey(tmp) && map.get(tmp) <= 1){
                map.remove(tmp);
            }
        }
        return res;
    }
}