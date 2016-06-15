public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int res = 0;
        int j = 0;
        for(int i = 0; i < s.length(); i++){
            while(j < s.length()){
                char tmp = s.charAt(j);
                if(map.size() < 2 || map.containsKey(tmp)){
                    if(map.containsKey(tmp)){
                        map.put(tmp, 1 + map.get(tmp));
                    }else{
                        map.put(tmp, 1);
                    }
                    j++;
                }else{
                    break;
                }
            }
            res = Math.max(res, j - i);
            char tmp = s.charAt(i);
            if(map.containsKey(tmp) && map.get(tmp) <=1){
                map.remove(tmp);
            }else if(map.containsKey(tmp) && map.get(tmp) > 1){
                map.put(tmp, map.get(tmp) - 1);
            }
        }
        return res;
    }
}