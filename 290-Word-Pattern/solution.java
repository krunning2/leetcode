public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if(s.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c) && !map.get(c).equals(s[i])){
                return false;
            }else if(!map.containsKey(c) && set.contains(s[i])){
                return false;
            }else if(!map.containsKey(c) && !set.contains(s[i])){
                map.put(c, s[i]);
                set.add(s[i]);
            }
        }
        return true;
    }
}