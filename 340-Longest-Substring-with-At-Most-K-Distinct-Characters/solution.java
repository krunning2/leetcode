public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0 || k <= 0){
            return 0;
        }
        int p1 = 0, p2 = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int res = 0;
        while(p2 < s.length()){
            char c2 = s.charAt(p2);
            if(map.containsKey(c2)){
                map.put(c2, map.get(c2) + 1);
            }else{
                map.put(c2, 1);
            }
            
            while(p1 <= p2 && map.size() > k){
                char c1 = s.charAt(p1);
                if(map.get(c1) > 1){
                    map.put(c1, map.get(c1) - 1);
                }else{
                    map.remove(c1);
                }
                p1++;
            }
            p2++;
            res = Math.max(p2 - p1);
        }
        return res;
    }
}