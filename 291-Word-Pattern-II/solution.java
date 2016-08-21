public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern == null || pattern.length() == 0) return str == null || str.length() == 0;
        return helper(pattern, str, 0, 0, new HashMap<>(), new HashSet<>());
    }
    private boolean helper(String pattern, String str, int pos1, int pos2, Map<Character, String> map, Set<String> set){
        if(pos1 == pattern.length() && pos2 == str.length()){
            return true;
        }
        if(pos1 >= pattern.length() || pos2 >= str.length()){
            return false;
        }
        
        char cur = pattern.charAt(pos1);
        for(int i = pos2; i < str.length(); i++){
            String sub = str.substring(pos2, i + 1);
            if(!map.containsKey(c) && !map.get(c).equals(s)){
                map.put(cur, sub);
                set.add(sub);
                boolean res = helper(pattern, str, pos1 + 1, i + 1, map, set);
                if(res) return true;
                map.remove(cur);
                set.remove(sub);
            }else if(map.containsKey(c) && map.get(c).equals(s)){
                if(helper(pattern, str, pos1 + 1, i + 1, map, set)) return true;
            }
        }
        return false;
    }
    // private boolean isValid(Map<Character, String> map, Set<String> set, char c, String s){
    //     if(map.containsKey(c) && !map.get(c).equals(s)){
    //         return false;
    //     }else if(!map.containsKey(c) && set.contains(s)){
    //         return false;
    //     }
    //     return true;
    // }
}