public class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        if(pattern == null || pattern.length() == 0) return str == null || str.length() == 0;
        return helper(pattern, str, 0, 0, new HashMap<>(), new HashSet<>());
    }
    private boolean helper(String pattern, String str, int p1, int s1, Map<Character, String> map, Set<String> set){
        if(p1 == pattern.length() && s1 == str.length()){
            return true;
        }
        if(p1 >= pattern.length() || s1 >= str.length()){
            return false;
        }
        for(int i = s1; i < str.length(); i++){
            String cur = str.substring(s1, i + 1);
            char c = pattern.charAt(p1);
            if(!map.containsKey(c) && !set.contains(cur)){
                map.put(c, cur);
                set.add(cur);
                boolean flag = helper(pattern, str, p1 + 1, i + 1, map, set);
                if(flag) return true;
                map.remove(c);
                set.remove(cur);
            }else if(map.containsKey(c) && map.get(c).equals(cur)){
                if(helper(pattern, str, p1 + 1, i + 1, map, set)) return true;
            }
        }
        return false;
    }
}