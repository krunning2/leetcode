public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null || str == null){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] strs = str.split(" ");
        if(strs.length != pattern.length()){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c) && !map.get(c).equals(strs[i])){
                return false;
            }
            if(!map.containsKey(c) && set.contains(strs[i])){
                return false;
            }
            if(!map.containsKey(c) && !set.contains(strs[i])){
                map.put(c, strs[i]);
                set.add(strs[i]);
            }
        }
        return true;
    }
}