public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null) return s == null && t == null;
        if(s.length() != t.length()) return false;
        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map.containsKey(c1) && map.get(c1) != c2){
                return false;
            }else if(!map.containsKey(c1) && set.contains(c2)){
                return false;
            }
            map.put(c1, c2);
            set.add(c2);
        }
        return true;
    }
}