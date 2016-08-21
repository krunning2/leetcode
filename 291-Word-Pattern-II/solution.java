public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        return helper(pattern, str, 0, 0, new HashMap<>(), new HashSet<>());
    }
    private boolean helper(String pattern, String str, int pos1, int pos2, Map<Character, String> map, Set<String> set){
        if(pos1 == pattern.length()){
            return true;
        }
        char cur = pattern.charAt(pos1);
        for(int i = pos2; i < str.length(); i++){
            String sub = str.substring(pos2, i + 1);
            if(isValid(map, set, cur, sub)){
                map.put(cur, sub);
                set.add(cur);
                helper(pattern, str, pos1 + 1, i + 1, map, set);
                map.remove(cur);
                set.remove(cur);
            }
        }
    }
    private boolean isValid(Map<Character, String> map, Set<String> set, char c, String s){
        if(map.containsKey(c) && !map.get(c).equals(s[i])){
            return false;
        }else if(!map.containsKey(c) && set.contains(s[i])){
            return false;
        }
        return true;
    }
}