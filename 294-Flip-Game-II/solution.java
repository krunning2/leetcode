public class Solution {
    public boolean canWin(String s) {
        return helper(s, new HashMap<>());
    }
    private boolean helper(String s, Map<String, Boolean> map){
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+'){
                String substring = s.substring(0, i) + "--" + s.substring(i + 2);
                if(!helper(substring, map)){
                    map.put(substring, Boolean.TRUE);
                    return true;
                }
            }
        }
        map.put(s, Boolean.FALSE);
        return false;
    }
}