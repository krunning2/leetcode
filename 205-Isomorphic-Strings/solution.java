public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        Set<Character> set = new HashSet<Character>();
        if(s == null || t == null) return s == null && t == null;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i)) && t.charAt(i) != map.get(s.charAt(i)) ||  set.contains(t.charAt(i))&& !map.containsKey(s.charAt(i))){
                return false;
            }
            set.add(t.charAt(i));
            map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}