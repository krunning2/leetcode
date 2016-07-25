public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Character, Integer> map2 = new HashMap<Character, Integer>();
        if(s == null || t == null) return s == null && t == null;
        for(Integer i = 0; i < s.length(); i++){
            if(map.put(s.charAt(i), i) != map2.put(t.charAt(i), i)){
                return false;
            }
        }
        return true;
    }
}